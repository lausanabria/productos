let url = 'http://localhost:8080/products/productList';
var new_header = new Headers();
var responseStatus;
var datos;

fetch(url,{
    headers: new_header
})
    .then(function(response) {
        responseStatus=response.status
        return response.json();
       
    })
    .then((responseJson) => {
        if (responseStatus == 200){
           
            $(document).ready(function () {

                $('table').bootstrapTable({
                    data: mydata
                });
                });
                var mydata = responseJson
        }
        else{
            Swal.fire({
                icon: 'error',
                title: 'No se encontraron datos en el listado',
                text: responseJson.respuesta
            })
        }
})

