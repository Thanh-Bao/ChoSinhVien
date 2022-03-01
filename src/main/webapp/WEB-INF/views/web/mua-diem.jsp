<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/common/taglib.jsp" %>
<!-- Section-->
<section>

    <div class="container white px-4 px-lg-4 mt-3 py-4">
        <div class=" row gx-4 gx-lg-5  justify-content-center">
            <div class="col-md-8">
                <div class="container">
                    <div class="row justify-content-center">
                        <c:forEach var="servicePack" items="${servicePacks}">
                            <div class="col-md-4 mb-5">
                                <div class="card h-100 product-card">
                                    <div class="card-body canh-giua-flex-column">
                                        <div><b>${servicePack.name}</b></div>
                                        <div>${servicePack.points} <i style="color: yellow;" class="fa fa-star"
                                                                      aria-hidden="true"></i></div>
                                        <div class="text-center">
                                            <p class="fw-bold" style="color: red;">Giá: ${servicePack.price}</p>
                                        </div>

                                        <form action="/mua-diem/add" method="post">
                                            <input type="hidden" name="servicePackId" value="${servicePack.id}">
                                            <input type="hidden" name="quantity" value="1">
                                            <button class="btn btn-outline-primary">
                                                <i class="fa fa-plus" aria-hidden="true"></i> Thêm vào giỏ
                                            </button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="p-3" style="background-color: #0097ff; color: #fff;">
                    <div class="text-center" style="font-size: 20px;">Hóa đơn</div>
                    <hr>
                    <c:forEach var="cartItem" items="${cart.cartItems}">
                        <div class="d-flex mb-3" style="color: #fff;">
                            <div class="mt-2">
                                <span>${cartItem.servicePack.name}</span>
                            </div>
                            <div style="display: block; margin-left:  auto; margin-right: 0;">
                                <form action="/mua-diem/add" method="post">
                                    <button onclick="setQuantityCartItemDecrease(${cartItem.servicePack.id})"
                                            id="negative" style=" border-radius: 10%;" class="btn btn-outline-light">
                                        <span style="padding-left: 0.125rem; padding-right: 0.125rem;"><b>-</b></span>
                                    </button>
                                    <span class="mx-2"><b>${cartItem.quantity}</b> </span>
                                    <input type="hidden" name="servicePackId" value="${cartItem.servicePack.id}">
                                    <input id="quantity${cartItem.servicePack.id}" type="hidden" name="quantity"
                                           value="0">
                                    <button onclick="setQuantityCartItemIncrease(${cartItem.servicePack.id})"
                                            id="positive" style=" border-radius: 10%;" class="btn btn-outline-light">
                                        <span><b>+</b></span></button>
                                </form>
                            </div>
                        </div>
                    </c:forEach>
                    <hr>
                    <div style="font-size: 20px; color: #fff;">
                        Tổng thanh toán:
                    </div>
                    <div style="font-size: 30px; color: #fff;" class="mb-3">
                        <b>${cart.amountTotal}</b>
                    </div>
                    <div class="canh-giua">
                        <form action="/mua-diem/thanh-toan" method="post">
                            <button class=" btn btn-outline-light">
                                <i class="fa fa-credit-card" aria-hidden="true"></i></i> Thanh toán
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
