var tituloLivro,
    subTituloLivro,
    autorLivro,
    anoLivro = "0000",
    ISBNLivro,
    thumbLivro;

function bookSearch() {
    console.log("RUNNING");

    var search = document.getElementById('search').value;
    document.getElementById('results').innerHTML = "";

    console.log(search);

    var urlSearch = "https://www.googleapis.com/books/v1/volumes?q=" + search;

    $.ajax({
        url: urlSearch,
        dataType: "json",

        success: function(data) {
            // console.log(data);

            for (i = 0; i < 10; i++) {
                tituloLivro = data.items[i].volumeInfo.title.replace(/\s/g, "¨").toUpperCase()
                autorLivro = data.items[i].volumeInfo.authors[0].replace(/\s/g, "¨").toUpperCase()
                subTituloLivro = data.items[i].volumeInfo.subtitle
                ISBNLivro = data.items[i].volumeInfo.industryIdentifiers[0].identifier
                thumbLivro = data.items[i].volumeInfo.imageLinks
                anoLivro = data.items[i].volumeInfo.publishedDate;

                console.log(anoLivro)

                // =========== TRATANDO O SUBTITULO - CASO TENHA ===========
                if (subTituloLivro === void(0)) {
                    subTituloLivro = " ";
                    // console.log("igual");

                } else {
                    subTituloLivro = subTituloLivro.toUpperCase()
                }

                // =========== TRATANDO A IMAGEM DE CAPA ===========
                if (thumbLivro === void(0)) {
                    thumbLivro = "/assets/images/foto.png";
                    console.log("igual");

                } else {
                    thumbLivro = data.items[i].volumeInfo.imageLinks.smallThumbnail
                }

                // =========== TRATANDO O ANO DE LIVRO - CASO TENHA ===========
                if (anoLivro === void(0) || anoLivro === null) {
                    anoLivro = "0000";
                    // console.log("anolivro UNDEFINED");

                } else {
                    anoLivro = anoLivro.substr(0, 4);
                }

                // console.log(subTituloLivro);

                results.innerHTML += "<li style=\" width: 60%; margin: 1em auto;padding: 1em; background: #f9f9f9; border: 1px solid #ccc;\" >" +

                    '<img style="float: right; width: 100px;" src=\'' + thumbLivro + '\'><br>' +

                    "<a id=" + i + "-li" + " href=# >" + tituloLivro + "<br>" + subTituloLivro + "<br>" + autorLivro + "</a>" + "<br>" +
                    "<button style=\"width: 100px;\" id=\"btn-busca\" onclick=fillInput(\"" + tituloLivro + "\"\,\"" + autorLivro + "\"\,\"" + anoLivro + "\"\,\"" + ISBNLivro + "\"\,\"" + thumbLivro + "\")>Este</button>" +

                    "</li>"
            }

        },

        type: 'GET'
    });

}

function fillInput(titulo, autor, ano, isbn, thumLink) {
    // console.log("click")
    
    document.getElementById("titulo").value = titulo.replace(/¨/g, " ");
    document.getElementById("autor").value = autor.replace(/¨/g, " ");
    document.getElementById("isbn").value = isbn;
    document.getElementById("ano").value = ano;

    document.getElementById("capa-value").value = thumLink;

    document.getElementById("overlay").style.display = "none";

    document.getElementById("titulo").readOnly = true;
    document.getElementById("autor").readOnly = true;
    document.getElementById("isbn").readOnly = true;
    document.getElementById("ano").readOnly = true;



}

document.getElementById('button').addEventListener('click', bookSearch, false);