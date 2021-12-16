<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/common/taglib.jsp" %>
<div id="logreg-forms">

    <!-- đăng nhập -->
    <form class="form-signin">
        <h1 class="h3 mb-3 font-weight-normal" style="text-align: center">Đăng nhập</h1>
        <div class="social-login">
            <button class="btn facebook-btn social-btn" type="button"><span><i class="fa fa-facebook-f"></i> Sign in with Facebook</span>
            </button>
            <button class="btn google-btn social-btn" type="button"><span><i class="fa fa-google"
                                                                             aria-hidden="true"></i> Sign in with Google+</span>
            </button>
        </div>
        <p style="text-align:center"> Hoặc </p>

        <input type="email" id="inputEmail" class="form-control" placeholder="Nhập số điện thoại của bạn" required=""
               autofocus="">

        <input type="password" id="inputPassword" class="form-control" placeholder="Nhập mật khẩu của bạn" required="">

        <button style="width: 100%;" class="btn btn-success btn-block" type="submit"><i class="fa fa-sign-in"
                                                                                        aria-hidden="true"></i> Đăng
            nhập
        </button>
        <a style="text-align: center;" href="#" id="forgot_pswd">Bạn quên mật khẩu?</a>
        <hr>
        <!-- <p>Don't have an account!</p>  -->
        <button style="width: 100%;" class="btn btn-primary btn-block" type="button" id="btn-signup"><i
                class="fa fa-user-plus"></i> Đăng kí tài khoản mới
        </button>
    </form>

</div>