document.getElementById('scrollableDiv').addEventListener('scroll', function() {
  var div = this;
  var scrollTop = div.scrollTop; // 스크롤된 양을 가져옵니다.
  var maxHeight = div.scrollHeight - div.clientHeight; // 최대 스크롤 가능한 양을 계산합니다.
  var opacity = scrollTop / maxHeight; // 스크롤 위치에 따라 투명도를 계산합니다.
  
  div.style.opacity = opacity; // 계산된 투명도를 적용합니다.
});