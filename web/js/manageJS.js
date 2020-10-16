function delStu(name) {
    const check = confirm("确定要删除当前学生吗?");
    if (check) {
        const checkPwd = prompt("请输入密码:");
        if (checkPwd !== null) {
            window.location = "ManageStu?name=" + name + "&password=" + checkPwd + "&time=" + new Date().getTime();
        }
    }
}

function modifyStu(name) {
    location.href = "GetInfoByName?name=" + name;
}
