const SIZE = 5;
var page = 0;

function reloadTableProducts() {
    $.ajax({
        url: "http://localhost:8080/products?page=" + page + "&size=" + SIZE,
        method: "GET",
        dataType: "JSON",
        success: function (products) {
            const $trPorductTemplete = $("#tr-product-templete");
            const $tbody = $("tbody");
            $tbody.children("tr:not(#tr-product-template)").remove();

            for (let i = 0; i < products.content.length; i++) {
                const product = products.content[i];
                const $trProduct = $trPorductTemplete.clone();
                $trProduct.removeAttr("id");
                $trProduct.children(".td-product-id").text(product.id);
                $trProduct.children(".td-product-name").text(product.name);
                $trProduct.children(".td-product-price").text(product.price);
                $trProduct.children(".td-product-currency").text(product.currency);
                $trProduct.children(".td-product-unit").text(product.unit);
                $tbody.append($trProduct);
            }
        }
    });
}

function getProductById(id) {
    $.ajax({
        url: "http://localhost:8080/products/" + id,
        method: "GET",
        dataType: "JSON",
        success: function (product) {
            $("#input-product-id").val(product.id);
            $("#input-product-name").val(product.name);
            $("#input-product-price").val(product.price);
            $("#input-product-currency").val(product.currency);
            $("#input-product-unit").val(product.unit);
        }
    });
}

$("#table-products").on("clik", "tr", function () {
    var id = $(this).find("td:first-child").text();
    getProductById(id);
});

reloadTableProducts();