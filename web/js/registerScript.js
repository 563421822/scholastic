function checkName() {
    const obj = document.getElementById("name").value;
    const regExp = /^[a-zA-Z0-9_\u4e00-\u9fa5]{2,5}$/;
    if (obj === "" || !regExp.test(obj)) {
        document.getElementById("warnName").style.color = "red";
        document.getElementById("warnName").innerHTML = "用户名不能为空或输入不符合规范!";
        return false;
    } else {
        document.getElementById("warnName").style.color = "lightblue";
        document.getElementById("warnName").innerHTML = "√"
        return true;
    }
}

function checkPwd() {
    checkRePwd();
    const obj = document.getElementById("password").value;
    if (obj === "" || obj.length < 6) {
        document.getElementById("warnPwd").style.color = "red";
        document.getElementById("warnPwd").innerHTML = "密码不能为空或密码长度有误!";
        return false;
    } else {
        document.getElementById("warnPwd").style.color = "lightblue";
        document.getElementById("warnPwd").innerHTML = "√";
        return true;
    }
}

function checkRePwd() {
    const obj = document.getElementById("rePassword").value;
    if (document.getElementById("password").value === "" || document.getElementById("password").value.length < 6) {
        document.getElementById("warnRePwd").style.color = "red";
        document.getElementById("warnRePwd").innerHTML = "原密码不能为空或原密码长度有误!";
        return false;
    } else if (obj === "" || obj !== document.getElementById("password").value) {
        document.getElementById("warnRePwd").style.color = "red";
        document.getElementById("warnRePwd").innerHTML = "重复密码不能为空或两次密码不一致!";
        return false;
    } else {
        document.getElementById("warnRePwd").style.color = "lightblue";
        document.getElementById("warnRePwd").innerHTML = "√";
        return true;
    }
}

function checkEmail() {
    const obj = document.getElementById("email").value;
    const regExp = /\w+([-+.]\w+)*@\w+([-.]\w+)*.\w+([-.]\w+)*/;
    if (obj === "" || !regExp.test(obj)) {
        document.getElementById("warnEmail").style.color = "red";
        document.getElementById("warnEmail").innerHTML = "邮箱不能为空或输入不规范!";
        return false;
    } else {
        document.getElementById("warnEmail").style.color = "lightblue";
        document.getElementById("warnEmail").innerHTML = "√";
        return true;
    }
}

function checkAgree() {
    const obj = document.getElementById("agree").checked;
    if (obj === true) {
        document.getElementById("commit").disabled = false;
        document.getElementById("warnAgree").style.color = "lightblue";
        document.getElementById("warnAgree").innerHTML = "√";
    } else {
        document.getElementById("commit").disabled = true;
        document.getElementById("warnAgree").style.color = "red";
        document.getElementById("warnAgree").innerHTML = "请同意协议!";
    }
}

function checkAll() {
    const nameResult = checkName();
    const PwdResult = checkPwd();
    const rePwdResult = checkRePwd();
    const emailResult = checkEmail();
    const hobbyResult = function () {
        let count = 0;
        const obj = document.getElementsByName("hobby");
        for (let i = 0; i < obj.length; i++) {
            if (obj[i].checked === true) {
                count++;
            }
        }
        if (count < 2) {
            alert("爱好至少选择两个!");
            return false;
        } else {
            return true;
        }
    }
    if (nameResult && PwdResult && rePwdResult && emailResult && hobbyResult()) {
        return true;
    } else {
        return false;
    }
}