const SIZE = 5;
var page = 0;

function reloadTableProduct (){
    $.ajaxj({
        url: "http://localhost:8080/products?page=" + page + "&size=" + SIZE,
        method: "GET",
        dataType: "JSON",
        success: function (products) {
            const $trPorductTemplete = $("#tr-product-templete");
            const $tbody = $("tbody");
            $tbody.children("tr:not(#tr-product-template)").remove();

            for(let i = 0; i< products.content.length; i++){
                const product = product.content[i];
                const $trProduct = $trPorductTemplete.clon();
                $trProduct.removeAttr("id");
                $trProduct.children(".td-product-id").text(product.id);
                $trProduct.children(".td-product-name").text(product.name);
                $trProduct.children(".td-product-price").text(product.price);
                $trProduct.children(".td-product-currency").text(product.currency);
                $trProduct.children(".td-product-unit").text(product.unit);
                $tbody.append($trProduct);
            }
        }
    })
}

reloadTableProduct();