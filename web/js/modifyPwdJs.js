function isOldPwd() {
    const obj = document.getElementById("oldPwd").value;//隐藏域中的密码
    const input = document.getElementById("inputOldPwd").value;
    switch (obj === input) {
        case true:
            document.getElementById("ckOldPwd").style.color = "lightblue";
            document.getElementById("ckOldPwd").innerText = "√";
            return true;
        case false:
            document.getElementById("ckOldPwd").style.color = "red";
            document.getElementById("ckOldPwd").innerText = "原密码输入有误!";
            alert("原密码:" + obj + "\n输入的密码:" + input);
            return false;
    }
}

function isReNewPwd() {
    const old = document.getElementById("oldPwd").value;//隐藏域中的密码
    const obj = document.getElementById("inputNewPwd").value;
    const input = document.getElementById("inputRePwd").value;
    const regExp = /^\d{6}$/;
    switch (input === old) {
        case true:
            const info = confirm("您输入的新密码与原密码相同,是否继续?");
            switch (info) {
                case false:
                    document.getElementById("inputNewPwd").value = "";
                    document.getElementById("inputRePwd").value = "";
                    return false;
            }
        case false:
            switch (regExp.test(input) && obj === input) {
                case true:
                    document.getElementById("ckReNewPwd").style.color = "lightblue";
                    document.getElementById("ckReNewPwd").innerText = "√";
                    return true;
                default:
                    document.getElementById("ckReNewPwd").style.color = "red";
                    document.getElementById("ckReNewPwd").innerText = "×";
                    return false;
            }
    }
}

function checkAll() {
    const oldPwdResult = isOldPwd();
    const newPwdResult = isReNewPwd();
    return !!(oldPwdResult && newPwdResult);
}