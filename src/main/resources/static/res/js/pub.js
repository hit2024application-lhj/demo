const tokenStr = "token";
const cityStr = "city";
const cookieStr = "outTime";

// 封装Vue实例的方法
function createVueInstance(options) {
    let token = getToken();
    options.el = '#app';
    if (!("getCity" in options.data)) {
        options.data.getCity = true;
    }
    options.data.cityList = [];
    options.data.selCity ='';
    if (undefined == token || null == token || "" == token || '' == token) {
        options.data.token = '';
    } else {
        options.data.token = token;
    }
    if (!('methods' in options)) {
        options.methods = {}
    }
    options.methods.selectCity = function (city) {
        setCookie(cityStr, JSON.stringify(city), null);
        this.selCity = city;
    };
    options.methods.parseTime = function (time) {
        const date = new Date(time);
        const year = date.getFullYear();
        const month = ('0' + (date.getMonth() + 1)).slice(-2);
        const day = ('0' + date.getDate()).slice(-2);
        const hours = ('0' + date.getHours()).slice(-2);
        const minutes = ('0' + date.getMinutes()).slice(-2);
        return `${year}/${month}/${day} ${hours}:${minutes}`;
    };
    if ('mounted' in options) {
        options.methods.tempMounted = options.mounted;
    }
    options.mounted = function () {
        if ('tempMounted' in options.methods) {
            this.tempMounted();
        }
        let _this = this;
        if (this.getCity) {
            axios({
                method: "post",
                url: "/city/citylist",
            }).then(function (resp) {
                console.log(resp.data);
                _this.cityList = resp.data.data;
                _this.selCity = getCookie(cityStr);
                console.log(_this.selCity);
                if (_this.selCity == null) {
                    setCookie(cityStr, JSON.stringify(_this.selCity = _this.cityList[0]), null);
                } else {
                    _this.selCity = JSON.parse(_this.selCity);
                }
            }).catch(function (error) {
                console.log(error);
            }).then(function () {
                if ("inited" in options.methods)
                    _this.inited();
            });
        } else {
            if ("inited" in options.methods)
                _this.inited();
        }
    };
    return new Vue(options);
}

function convertToQueryString(...params) {
    // 创建一个空数组来存储参数键值对
    const queryString = [];
    // 遍历参数数组
    params.forEach(param => {
        // 拆解每个参数对象
        Object.entries(param).forEach(([key, value]) => {
            // 对于每个键值对，将其拼接成 key=value 的形式，并添加到数组中
            queryString.push(`${encodeURIComponent(key)}=${encodeURIComponent(value)}`);
        });
    });
    // 将数组中的键值对使用 & 连接起来，并返回最终的拼接结果
    return queryString.join('&');
}

function setCookie(name, value, days) {
    var d = new Date();
    if (days != null) {
        d.setTime(d.getTime() + (days * 24 * 60 * 60 * 1000)); // 设置cookie到期时间
        var expires = "expires=" + d.toGMTString();
        document.cookie = name + "=" + value + "; " + expires;
    } else {
        document.cookie = name + "=" + value + ";";
    }
}

function getCookie(cname) {
    const name = cname + "=";
    var res = document.cookie.split(';');
    for (var i = 0; i < res.length; i++) {
        var data = res[i].trim();
        if (data.indexOf(name) == 0) {
            return data.substring(name.length, data.length);
        }
    }
    return null;
}

function getLocalStorageValue(key) {
    if (null == getCookie(cookieStr)) {
        localStorage.clear();
        return "";
    }
    return localStorage.getItem(key);
}

function setLocalStorageValue(key, value) {
    if (null == getCookie(cookieStr)) {
        setCookie(cookieStr, new Date(), null);
    }
    localStorage.setItem(key, value);
}

function getToken() {
    return getLocalStorageValue(tokenStr);
}

function setToken(token) {
    setLocalStorageValue(tokenStr, token);
}

function parseResp(resp) {
    if (resp.data.code == 501) {
        setToken("");
        window.location.href = "/res/pages/login.html";
    }
}

function getQueryString(name) {
    var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i');
    var r = window.location.search.substr(1).match(reg);
    if (r != null) {
        return unescape(r[2]);
    }
    return null;
}