(function ($) {
    $.fn.extend({
        SlidePattern: function (json) {
            var This = $(this),
                ThisUl = $(this).find("ul.rccUl"),
                ThisLeftBtn = $(this).find("span.rclPrev"),
                ThisRightBtn = $(this).find("span.rcrNext"),
                movenum = 0,
                movespeed = 0,
                margin = parseInt(ThisUl.find("li").eq(0).css("marginRight") + ThisUl.find("li").eq(0).css("marginLeft")),
                scrolltimer = null,
                rotatetimer = null,
                ThisLi = ThisUl.find("li"),
                direction = json["Direction"],
                toggle = json["Autoclose"],
                way = json["Way"],
                scrollnum = json["ScrollNum"],
                speed = json["Speed"],
                time = json["Time"];
            ThisUl.html(ThisUl.html() + ThisUl.html());
            ThisUl.find("li").removeClass("active").eq(0).addClass("active");
            if (direction != "top") {
                var UlWidth = 0;
                ThisUl.find("li").each(function () {
                    UlWidth += $(this).get(0).offsetWidth + margin
                });
                ThisUl.css({
                    width: UlWidth
                });
            }
            ;
            switch (direction) {
                case "left":
                    movespeed = speed;
                    break;
                case "right":
                    movespeed = -speed;
                    break
            }
            ;

            function doscroll() {
                clearInterval(scrolltimer);
                scrolltimer = setInterval(function () {
                    scrollchange()
                }, time)
            };

            function dorotate() {
                clearInterval(rotatetimer);
                rotatetimer = setInterval(function () {
                    rotatechange()
                }, time)
            };

            function scrollchange(btnclass) {
                switch (direction) {
                    case "left":
                        btnclass ? scrollbtnclick() : scrollleft_overflow();
                        scrollright_overflow();
                        break;
                    case "right":
                        btnclass ? scrollbtnclick() : scrollright_overflow();
                        scrollleft_overflow();
                        break
                }
                ;

                function scrollbtnclick() {
                    if (btnclass.search("rclPrev") != -1) {
                        movespeed = speed
                    } else if (btnclass.search("rcrNext") != -1) {
                        movespeed = -speed
                    }
                };

                function scrollleft_overflow() {
                    if (movenum < -ThisUl.width() / 2) movenum = 0
                };

                function scrollright_overflow() {
                    if (movenum > 0) movenum = -ThisUl.width() / 2
                };
                movenum -= movespeed;
                ThisUl.css({
                    left: movenum
                })
            };

            function rotatechange(btnclass) {
                var rotatevalue = 0;
                switch (direction) {
                    case "left":
                        btnclass ? rotatebtnclick() : movenum -= scrollnum;
                        rotateleft_overflow();
                        break;
                    case "right":
                        btnclass ? rotatebtnclick() : movenum += scrollnum;
                        right_overflow();
                        break;
                    case "top":
                        movenum -= scrollnum;
                        rotatetop_overflow();
                        break
                }
                ;

                function rotatebtnclick() {
                    if (btnclass.search("rclPrev") != -1) {
                        movenum -= scrollnum;
                        rotateleft_overflow()
                    } else if (btnclass.search("rcrNext") != -1) {
                        movenum += scrollnum;
                        right_overflow()
                    }
                };

                function rotateleft_overflow() {
                    if (movenum < -ThisUl.find("li").length / 2) {
                        movenum = -scrollnum;
                        ThisUl.css({
                            left: 0
                        })
                    }
                };

                function right_overflow() {
                    if (movenum > 0) {
                        movenum = -ThisUl.find("li").length / 2 + scrollnum;
                        ThisUl.css({
                            left: -ThisUl.find("li").length / 2 * (ThisUl.find("li").get(0).offsetWidth + margin)
                        })
                    }
                };

                function rotatetop_overflow() {
                    if (parseInt(ThisUl.css("top")) <= -ThisUl.get(0).offsetHeight / 2) {
                        movenum = -scrollnum;
                        ThisUl.css({
                            top: 0
                        })
                    }
                };
                if (direction != "top") {
                    rotatevalue = parseInt(ThisUl.find("li").get(0).offsetWidth + margin) * movenum;
                    ThisUl.stop().animate({
                        left: rotatevalue
                    })
                } else {
                    rotatevalue = parseInt(ThisUl.find("li").get(0).offsetHeight) * movenum;
                    ThisUl.stop().animate({
                        top: rotatevalue
                    })
                }
                ;
                ThisUl.find("li").removeClass("active").eq(-movenum).addClass("active")
            };
            startFn();
            btnFn(ThisLeftBtn);
            btnFn(ThisRightBtn);

            function startFn() {
                if (!toggle) {
                    way == "scroll" ? doscroll() : dorotate()
                }
            };

            function endFn() {
                if (!toggle) {
                    way == "scroll" ? clearInterval(scrolltimer) : clearInterval(rotatetimer)
                }
            };

            function btnFn(btn) {
                btn.bind("click", function () {
                    way == "scroll" ? scrollchange($(this).attr("class")) : rotatechange($(this).attr("class"))
                }).hover(function () {
                    endFn()
                }, function () {
                    startFn()
                })
            };
            ThisUl.hover(function () {
                endFn()
            }, function () {
                startFn()
            });
        }
    })
})(jQuery);