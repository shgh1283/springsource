// actionForm action 수정
const actionForm = document.querySelector("#actionForm");

// Remove 클릭 시
document.querySelector(".btn-danger").addEventListener("click", (e) => {
  if (!confirm("정말로 삭제하시겠습니까?")) {
    return;
  }
  actionForm.action = "/guestbook/remove";
  actionForm.submit();
});

// List 클릭시
document.querySelector(".btn-info").addEventListener("click", (e) => {
  // gno 삭제
  actionForm.querySelector("[name='gno']").remove();
  // actionForm method 수정(get)
  actionForm.method = "get";
  actionForm.submit();
});
