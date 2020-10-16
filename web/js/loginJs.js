function cannotSee() {
    document.getElementById("ckCode").src = "CheckCodeServlet?arg=" + new Date().getTime();
}

function isCode() {
    const code = window.document.getElementById("code").value;
    if (code.length === 4) {
        return true;
    } else {
        alert("验证码的输入有误!");
    }
}