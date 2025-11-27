const bulidHTML = (XHR) => {
  const item = XHR.response;
  const html = `<div>
                        <div class="article">
                        ${item.text}
                        </div>
                    </div>`;
  return html;
};
function post() {
  const postBtn = document.getElementById("submit_btn");
  postBtn.addEventListener("click", (e) => {
    const form = document.getElementById("new_article");
    const formData = new FormData(form);
    const XHR = new XMLHttpRequest();
    XHR.open("POST", "/articles", true);
    XHR.responseType = "json";
    XHR.send(formData);
    XHR.onload = () => {
      if (XHR.status != 200) {
        alert(`Error ${XHR.status}: ${XHR.response.error}`);
        return null;
      }
      const contentsArea = document.getElementById("contents_area");
      const articleText = document.getElementById("article_text");
      contentsArea.insertAdjacentHTML("afterbegin", bulidHTML(XHR));
      articleText.value = "";
      const charNum = document.getElementById("char_num");
      charNum.innerHTML = "0文字";
    };
    e.preventDefault();
  });
}

window.addEventListener("load", post);
