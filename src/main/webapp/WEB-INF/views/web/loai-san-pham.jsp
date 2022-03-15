<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/common/taglib.jsp" %>

<!-- filter -->
<section>
    <div class="container white px-2 px-lg-2 mt-3 py-2 canh-giua">

        <a href='<c:url value="/${slug}"/>' type="button" class="btn btn-outline-primary">Tin mới</a>

        <div class="btn-group">
            <button type="button" class="btn btn-outline-primary dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                Khu vực <i class="fa fa-map-marker" aria-hidden="true"></i>
            </button>
            <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="#">Action</a></li>
                <li><a class="dropdown-item" href="#">Another action</a></li>
                <li><a class="dropdown-item" href="#">Something else here</a></li>
                <li><hr class="dropdown-divider"></li>
                <li><a class="dropdown-item" href="#">Separated link</a></li>
            </ul>
        </div>

        <div class="btn-group" role="group" aria-label="Basic outlined example">
            <button type="button" class="btn btn-outline-primary" disabled>Giá</button>
            <a href='<c:url value="/${slug}/gia-giam"/>' type="button" class="btn btn-outline-primary"><i class="fa fa-arrow-down" aria-hidden="true"></i></a>
            <a href='<c:url value="/${slug}/gia-tang"/>' type="button" class="btn btn-outline-primary"><i class="fa fa-arrow-up" aria-hidden="true"></i></a>
        </div>

    </div>
</section>

<!-- Section-->
<section>

    <div class="container white px-4 px-lg-4 mt-3 py-4">
        <form  action='<c:url value ="/${slug}"/>' id="formSubmit" method="get">
            <div class=" row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                <c:forEach var="item" items="${products}">
                    <div class="col mb-5">
                        <a href="product-details.html">
                            <div class="card h-100 product-card">
                                <!-- Product image-->
                                <img class="card-img-top" src="${item.images.get(0).link}"
                                     alt="..."/>
                                <!-- Product details-->
                                <div class="card-body canh-giua-flex-column">
                                    <div class="text-center">
                                        <!-- Product name-->
                                        <p class="">${item.name} </p>
                                        <!-- Product price-->
                                        <p class="fw-bold" style="color: red;">${item.price}</p>
                                    </div>
                                    <a class="btn btn-outline-danger"><i class="fa fa-heart-o"
                                                                         aria-hidden="true"></i></a>
                                </div>
                            </div>
                        </a>
                    </div>
                </c:forEach>
            </div>
            <div class="container canh-giua">
                <ul class="pagination" id="pagination"></ul>
                <input type ="hidden" value ="" id ="page" name = "page"/>
                <input type ="hidden" value ="" id ="limit" name = "limit"/>
            </div>
        </form>
    </div>


</section>

<script type="text/javascript">
    var totalPages = ${paging.totalPage};
    var currentPage = ${paging.page};
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPages,
            visiblePages: 10,
            startPage: currentPage,
            onPageClick: function (event, page) {
                if (currentPage != page) {
                    $('#limit').val(2);
                    $('#page').val(page);
                    $('#formSubmit').submit();
                }

            }
        });
    });
</script>