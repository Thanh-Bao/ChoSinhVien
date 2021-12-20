<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/common/taglib.jsp" %>
<div id="logreg-forms">

    <!-- đăng nhập -->
    <form name ="f" action="/login" method="post" class="form-signin">
        <h1 class="h3 mb-3 font-weight-normal" style="text-align: center">Đăng nhập</h1>
        <div class="social-login">
            <button class="btn facebook-btn social-btn" type="button"><span><i class="fa fa-facebook-f"></i> Sign in with Facebook</span>
            </button>
            <button class="btn google-btn social-btn" type="button"><span><i class="fa fa-google"
                                                                             aria-hidden="true"></i> Sign in with Google+</span>
            </button>
        </div>
        <p style="text-align:center"> Hoặc </p>

        <input type="email" name="username" class="form-control" placeholder="Email" required="" autofocus="">

        <input type="password" name="password" class="form-control" placeholder="Password" required="">

        <button style="width: 100%;" class="btn btn-success btn-block" name="submit" type="submit"><i class="fa fa-sign-in" aria-hidden="true"></i> Đăng nhập
        </button>
        <a style="text-align: center;" href="#" id="forgot_pswd">Bạn quên mật khẩu?</a>
        <hr>
        <!-- <p>Don't have an account!</p>  -->
        <button style="width: 100%;" class="btn btn-primary btn-block" type="button" id="btn-signup"><i
                class="fa fa-user-plus"></i> Đăng kí tài khoản mới
        </button>
    </form>

    <!-- đổi mật khẩu -->
    <form action="/reset/password/" class="form-reset">
        <input type="email" id="resetEmail" class="form-control" placeholder="Email address" required="" autofocus="">
        <button style="width: 100%;" class="btn btn-primary btn-block" type="submit">Reset Password</button>
        <a style="text-align: center;" href="#" id="cancel_reset"><i class="fa fa-angle-left"></i> Trở lại</a>
    </form>

    <!-- đăng kí -->
    <form:form action="signup" class="form-signup" method="post" modelAttribute="user">
        <h1 class="h3 mb-3 font-weight-normal" style="text-align: center">Đăng ký</h1>
        <div class="d-flex mb-3">
            <button class="btn facebook-btn social-btn me-1" type="button"><span><i class="fa fa-facebook-f"></i> Sign in with Facebook</span>
            </button>
            <button class="btn google-btn social-btn" type="button"><span><i class="fa fa-google" aria-hidden="true"></i> Sign in with Google+</span>
            </button>
        </div>
        <p style="text-align:center"> Hoặc </p>

        <form:input type="email" class="form-control" placeholder="Email" required="true" autofocus="true" path="email"/>
        <form:input type="text" class="form-control" placeholder="Họ tên" required="true" path="name"/>
        <form:input type="text" class="form-control" placeholder="Số điện thoại" required="true" path="phone"/>
        <form:input type="text" class="form-control" placeholder="Địa chỉ" required="true" path="address"/>
        <form:password id="password" class="form-control" placeholder="Password" required="true" path="password"/>
        <input id="confirm_password" type="password" class="form-control" placeholder="Nhập lại Password" required/>

        <button style="width: 100%;" class="btn btn-primary btn-block" type="submit"><i class="fa fa-user-plus"></i>
            Đăng ký
        </button>
        <a style="text-align: center;" href="#" id="cancel_signup"><i class="fa fa-angle-left"></i> Trở lại</a>
    </form:form>
    <br>

</div>