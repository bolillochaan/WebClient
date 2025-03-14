/*!
 * current-device v0.9.1 - https://github.com/matthewhudson/current-device
 * MIT Licensed
 */
!function(n, o) {
    "object" == typeof exports && "object" == typeof module ? module.exports = o() : "function" == typeof define && define.amd ? define([], o) : "object" == typeof exports ? exports.device = o() : n.device = o()
}(window, function() {
    return function(n) {
        var o = {};
        function e(t) {
            if (o[t])
                return o[t].exports;
            var r = o[t] = {
                i: t,
                l: !1,
                exports: {}
            };
            return n[t].call(r.exports, r, r.exports, e),
            r.l = !0,
            r.exports
        }
        return e.m = n,
        e.c = o,
        e.d = function(n, o, t) {
            e.o(n, o) || Object.defineProperty(n, o, {
                enumerable: !0,
                get: t
            })
        }
        ,
        e.r = function(n) {
            "undefined" != typeof Symbol && Symbol.toStringTag && Object.defineProperty(n, Symbol.toStringTag, {
                value: "Module"
            }),
            Object.defineProperty(n, "__esModule", {
                value: !0
            })
        }
        ,
        e.t = function(n, o) {
            if (1 & o && (n = e(n)),
            8 & o)
                return n;
            if (4 & o && "object" == typeof n && n && n.__esModule)
                return n;
            var t = Object.create(null);
            if (e.r(t),
            Object.defineProperty(t, "default", {
                enumerable: !0,
                value: n
            }),
            2 & o && "string" != typeof n)
                for (var r in n)
                    e.d(t, r, function(o) {
                        return n[o]
                    }
                    .bind(null, r));
            return t
        }
        ,
        e.n = function(n) {
            var o = n && n.__esModule ? function() {
                return n.default
            }
            : function() {
                return n
            }
            ;
            return e.d(o, "a", o),
            o
        }
        ,
        e.o = function(n, o) {
            return Object.prototype.hasOwnProperty.call(n, o)
        }
        ,
        e.p = "",
        e(e.s = 0)
    }([function(n, o, e) {
        n.exports = e(1)
    }
    , function(n, o, e) {
        "use strict";
        e.r(o);
        var t = "function" == typeof Symbol && "symbol" == typeof Symbol.iterator ? function(n) {
            return typeof n
        }
        : function(n) {
            return n && "function" == typeof Symbol && n.constructor === Symbol && n !== Symbol.prototype ? "symbol" : typeof n
        }
          , r = window.device
          , i = {}
          , a = [];
        window.device = i;
        var c = window.document.documentElement
          , d = window.navigator.userAgent.toLowerCase()
          , u = ["googletv", "viera", "smarttv", "internet.tv", "netcast", "nettv", "appletv", "boxee", "kylo", "roku", "dlnadoc", "pov_tv", "hbbtv", "ce-html"];
        function l(n, o) {
            return -1 !== n.indexOf(o)
        }
        function s(n) {
            return l(d, n)
        }
        function f(n) {
            return c.className.match(new RegExp(n,"i"))
        }
        function b(n) {
            var o = null;
            f(n) || (o = c.className.replace(/^\s+|\s+$/g, ""),
            c.className = o + " " + n)
        }
        function p(n) {
            f(n) && (c.className = c.className.replace(" " + n, ""))
        }
        function w() {
            i.landscape() ? (p("portrait"),
            b("landscape"),
            y("landscape")) : (p("landscape"),
            b("portrait"),
            y("portrait")),
            v()
        }
        function y(n) {
            for (var o in a)
                a[o](n)
        }
        i.macos = function() {
            return s("mac")
        }
        ,
        i.ios = function() {
            return i.iphone() || i.ipod() || i.ipad()
        }
        ,
        i.iphone = function() {
            return !i.windows() && s("iphone")
        }
        ,
        i.ipod = function() {
            return s("ipod")
        }
        ,
        i.ipad = function() {
            var n = "MacIntel" === navigator.platform && navigator.maxTouchPoints > 1;
            return s("ipad") || n
        }
        ,
        i.android = function() {
            return !i.windows() && s("android")
        }
        ,
        i.androidPhone = function() {
            return i.android() && s("mobile")
        }
        ,
        i.androidTablet = function() {
            return i.android() && !s("mobile")
        }
        ,
        i.blackberry = function() {
            return s("blackberry") || s("bb10") || s("rim")
        }
        ,
        i.blackberryPhone = function() {
            return i.blackberry() && !s("tablet")
        }
        ,
        i.blackberryTablet = function() {
            return i.blackberry() && s("tablet")
        }
        ,
        i.windows = function() {
            return s("windows")
        }
        ,
        i.windowsPhone = function() {
            return i.windows() && s("phone")
        }
        ,
        i.windowsTablet = function() {
            return i.windows() && s("touch") && !i.windowsPhone()
        }
        ,
        i.fxos = function() {
            return (s("(mobile") || s("(tablet")) && s(" rv:")
        }
        ,
        i.fxosPhone = function() {
            return i.fxos() && s("mobile")
        }
        ,
        i.fxosTablet = function() {
            return i.fxos() && s("tablet")
        }
        ,
        i.meego = function() {
            return s("meego")
        }
        ,
        i.cordova = function() {
            return window.cordova && "file:" === location.protocol
        }
        ,
        i.nodeWebkit = function() {
            return "object" === t(window.process)
        }
        ,
        i.mobile = function() {
            return i.androidPhone() || i.iphone() || i.ipod() || i.windowsPhone() || i.blackberryPhone() || i.fxosPhone() || i.meego()
        }
        ,
        i.tablet = function() {
            return i.ipad() || i.androidTablet() || i.blackberryTablet() || i.windowsTablet() || i.fxosTablet()
        }
        ,
        i.desktop = function() {
            return !i.tablet() && !i.mobile()
        }
        ,
        i.television = function() {
            for (var n = 0; n < u.length; ) {
                if (s(u[n]))
                    return !0;
                n++
            }
            return !1
        }
        ,
        i.portrait = function() {
            return screen.orientation && Object.prototype.hasOwnProperty.call(window, "onorientationchange") ? l(screen.orientation.type, "portrait") : i.ios() && Object.prototype.hasOwnProperty.call(window, "orientation") ? 90 !== Math.abs(window.orientation) : window.innerHeight / window.innerWidth > 1
        }
        ,
        i.landscape = function() {
            return screen.orientation && Object.prototype.hasOwnProperty.call(window, "onorientationchange") ? l(screen.orientation.type, "landscape") : i.ios() && Object.prototype.hasOwnProperty.call(window, "orientation") ? 90 === Math.abs(window.orientation) : window.innerHeight / window.innerWidth < 1
        }
        ,
        i.noConflict = function() {
            return window.device = r,
            this
        }
        ,
        i.ios() ? i.ipad() ? b("ios ipad tablet") : i.iphone() ? b("ios iphone mobile") : i.ipod() && b("ios ipod mobile") : i.macos() ? b("macos desktop") : i.android() ? i.androidTablet() ? b("android tablet") : b("android mobile") : i.blackberry() ? i.blackberryTablet() ? b("blackberry tablet") : b("blackberry mobile") : i.windows() ? i.windowsTablet() ? b("windows tablet") : i.windowsPhone() ? b("windows mobile") : b("windows desktop") : i.fxos() ? i.fxosTablet() ? b("fxos tablet") : b("fxos mobile") : i.meego() ? b("meego mobile") : i.nodeWebkit() ? b("node-webkit") : i.television() ? b("television") : i.desktop() && b("desktop"),
        i.cordova() && b("cordova"),
        i.onChangeOrientation = function(n) {
            "function" == typeof n && a.push(n)
        }
        ;
        var m = "resize";
        function h(n) {
            for (var o = 0; o < n.length; o++)
                if (i[n[o]]())
                    return n[o];
            return "unknown"
        }
        function v() {
            i.orientation = h(["portrait", "landscape"])
        }
        Object.prototype.hasOwnProperty.call(window, "onorientationchange") && (m = "orientationchange"),
        window.addEventListener ? window.addEventListener(m, w, !1) : window.attachEvent ? window.attachEvent(m, w) : window[m] = w,
        w(),
        i.type = h(["mobile", "tablet", "desktop"]),
        i.os = h(["ios", "iphone", "ipad", "ipod", "android", "blackberry", "macos", "windows", "fxos", "meego", "television"]),
        v(),
        o.default = i
    }
    ]).default
});
//# sourceMappingURL=current-device.min.js.map
