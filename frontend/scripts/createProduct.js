var formulario = document.getElementById('formCrearProducto');
var campos = document.getElementsByTagName("input");
var campos2 = document.getElementsByTagName("textarea");

formulario.addEventListener('submit', function(e){
    e.preventDefault();
    
    var datos = new FormData(formulario);

    if(datos.get('nombre') === ""){
        Swal.fire({
            icon: 'error',
            title: 'Verifica tus datos',
            text: 'El nombre del producto no puede estar vacío'
        })
    }
    else{
        if (datos.get('descripcion')===""){
            Swal.fire({
                icon: 'error',
                title: 'Verifica tus datos',
                text: 'La descripción no puede estar vacía'
            })
        }
        else{
            executePOST()
        }
    }

    function executePOST(){
        var urlCrear = urlBase+"products/create";
        var new_header = new Headers();
        var responseStatus;

        fetch(urlCrear,{
            headers: {
                "Content-Type": "application/json",
            },
            method: "POST",
            body: JSON.stringify({ 
                nombre: datos.get('nombre'), 
                descripcion: datos.get('descripcion')
            })
        })
            .then(function(response) {
                responseStatus=response.status
                return response.json();
            })
            .then((responseJson) => {
               
                if (responseStatus == 200){
                    Swal.fire(
                        'Producto registrado!',
                        responseJson.respuesta,
                        'success'
                    )
                    cleanFields();
                }
                else{
                    Swal.fire({
                        icon: 'error',
                        title: 'No se pudo registrar el producto!',
                        text: responseJson.respuesta
                    })
                }
            })
            .catch(err => { throw err });
            
        /*fetch(urlCrear,{
            headers: new_header
        })
            .then(function(response) {
                return response.json()
            })
            .catch(err => { throw err });*/
    }

    function cleanFields(){
        campos['nombre'].value=""
        campos2['descripcion'].value=""
    }
    
})