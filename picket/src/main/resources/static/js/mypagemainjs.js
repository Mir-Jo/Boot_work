function selectAll1(selectAll)  {
  const checkboxes
     = document.querySelectorAll('input[name="mypagemain_ticket1"]');

  checkboxes.forEach((checkbox) => {
    checkbox.checked = selectAll.checked
  })
};
function selectAll2(selectAll)  {
  const checkboxes
     = document.querySelectorAll('input[name="mypagemain_ticket2"]');

  checkboxes.forEach((checkbox) => {
    checkbox.checked = selectAll.checked
  })
};