function count() {
  const textForm = document.getElementById("article_text");
  textForm.addEventListener("keyup", () => {
    const textNum = textForm.value.length;
    const countNum = document.getElementById("char_num");
    countNum.innerHTML = `${textNum}文字`;
  });
}

window.addEventListener("load", count);
