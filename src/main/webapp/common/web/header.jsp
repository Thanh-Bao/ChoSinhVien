<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-light ">
    <div class="container px-4 px-lg-5">
        <a class="navbar-brand" href="home.html">
            <img src="/template/web/assets/csv-logo.png" alt="">
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">

            <form class="d-flex  form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-primary active my-2 my-sm-0" type="submit">Search</button>
            </form>

            <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                <li class="nav-item me-1"><a class="nav-link" aria-current="page" href="quan-ly-tin.html"><i
                        class="fa fa-file-text" aria-hidden="true"></i> Quản lý tin</a></li>
                <li class="nav-item me-1"><a class="nav-link" href="#!"><i class="fa fa-commenting"
                                                                           aria-hidden="true"></i> Chat</a></li>
                <li class="nav-item me-1"><a class="nav-link" href="#!"><i class="fa fa-bell"
                                                                           aria-hidden="true"></i> Thông báo</a></li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">Thêm</a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li>
                            <a class="dropdown-item mt-2" href="profile.html">
                                <div>
                                    <img style="width: 60px; height: 60px; border-radius: 100%;" src="assets/sh.jpg"
                                         alt="">
                                    <span>Nguyễn Công Danh</span>

                                </div>
                            </a>
                        </li>
                        <hr class="dropdown-divider"/>
                        <li><a class="dropdown-item canh-giua-start" href="tin-luu.html"><i
                                class="fa fa-gratipay me-1" style="color: red; font-size: 30px;"
                                aria-hidden="true"></i>Tin đăng đã lưu</a></li>

                        <li><a class="dropdown-item canh-giua-start" href="#!"><i class="fa fa-users me-1"
                                                                                  style="color: royalblue; font-size: 25px;"
                                                                                  aria-hidden="true"></i>Bạn bè</a>
                        </li>
                        <hr class="dropdown-divider"/>
                        <li><a class="dropdown-item canh-giua-start" href="#!"><i class="fa fa-question-circle me-1"
                                                                                  style="font-size: 30px;"
                                                                                  aria-hidden="true"></i>Trợ giúp</a>
                        </li>
                        <li><a class="dropdown-item canh-giua-start" href="#!"><i class="fa fa-cog me-1"
                                                                                  style="font-size: 30px;"
                                                                                  aria-hidden="true"></i>Cài đặt thông
                            tin</a></li>
                        <li><a class="dropdown-item canh-giua-start" href="#!"><i class="fa fa-sign-out me-1"
                                                                                  style="font-size: 30px;"
                                                                                  aria-hidden="true"></i> Đăng xuất</a>
                        </li>
                    </ul>
                </li>
            </ul>

            <!-- sau khi dang nhap -->

            <!-- <div class="me-3 mb-3">
                <a href="profile.html">
                    <div class="canh-giua-start dang-nhap text-white">
                        <img style="width: 35px; height: 35px; border-radius: 100%;" src="assets/sh.jpg" alt="">
                        <span style="color: #ffffff;">Nguyễn Công Danh</span>
                    </div>
                </a>
            </div> -->

            <!-- truoc khi dang nhap -->
            <div class="me-3 mb-3 mt-3">
                <a href="login.html ">
                    <div class="canh-giua-start dang-nhap text-white">
                        <i class="fa fa-user-circle-o" style="font-size: 35px;" aria-hidden="true"></i>
                        <span class="mx-1">Đăng nhập</span>
                    </div>

                </a>
            </div>

            <div class="d-flex">
                <a href="tin-dang.html" class="btn btn-primary">
                    <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                    Đăng tin
                </a>
            </div>
        </div>
    </div>
</nav>