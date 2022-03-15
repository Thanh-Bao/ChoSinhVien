<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/common/taglib.jsp" %>
<!-- Carousel-->
<div class="container white py-4 px-4 px-lg-4 mt-4">
    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img class="d-block w-100" src="https://dummyimage.com/780x200/000/fff" alt="First slide">
            </div>
            <div class="carousel-item">
                <img class="d-block w-100" src="https://dummyimage.com/780x200/000/fff" alt="Second slide">
            </div>
            <div class="carousel-item">
                <img class="d-block w-100" src="https://dummyimage.com/780x200/000/fff" alt="Third slide">
            </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</div>
<!-- Categories -->
<section>
    <div class="container mt-3 white">
        <div class="row row-cols-xl-6 row-cols-sm-3 row-cols-2 justify-content-center">

           <c:forEach var="item" items="${categories}">
               <div class="col my-4">
                   <li>
                       <a href='<c:url value="/${item.slug}"/>' class="canh-giua-flex-column">
                           <div>
                               <img class="img-category" src="" alt="">
                           </div>
                           <span>${item.name}</span>
                       </a>
                   </li>
               </div>
           </c:forEach>


        </div>
    </div>
</section>

<!-- Section-->
<section>

    <div class="container white px-4 px-lg-4 mt-3 py-4">
        <form  action='<c:url value ="/trang-chu"/>' id="formSubmit" method="get">
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