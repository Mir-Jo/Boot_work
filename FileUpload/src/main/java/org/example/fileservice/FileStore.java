package org.example.fileservice;

import org.example.domain.UploadFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class FileStore {
    @Value("${file.dir}")
    private String fileDir;
    public String getFullPath(String filename) { return fileDir + filename;}
    public UploadFile storeFile(MultipartFile mFile) throws IOException { //파일 저장 2 u
        if(mFile.isEmpty()){
            return null;
        }
        //사용자가 업로드한 파일명
        String originalFilename = mFile.getOriginalFilename();
        //서버에 저장하는 파일명(uuid사용.확장자는 그대로)
        String storeFileName = createStoreFileName(originalFilename);
        mFile.transferTo(new File(getFullPath(storeFileName)));//저장
        return new UploadFile(originalFilename, storeFileName);
    }


    public List<UploadFile> storeFiles(List<MultipartFile> mFiles) throws IOException{
        List<UploadFile> uploadFiles = new ArrayList<>();
        for(MultipartFile mFile : mFiles){
            if(!mFile.isEmpty()){
                uploadFiles.add(storeFile(mFile));
            }
        }
        return uploadFiles;
    }
    private String createStoreFileName(String originalFilename) {
        //서버 내부에 저장될 유일한 이름의 파일명 return
        //String uuid = String.valueOf(System.currentTimeMillis());
        String uuid = UUID.randomUUID().toString();
        //a.jpg를 첨부하면 저장은 uuid.jpg로
        return uuid+"."+extractExt(originalFilename, uuid);
    }
    private String extractExt(String originalFilename, String uuid) {
        int pos = originalFilename.lastIndexOf(".");
        //확장자를 반환
        return originalFilename.substring(pos+1);
    }
}
