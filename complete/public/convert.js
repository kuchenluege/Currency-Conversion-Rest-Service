function button() {
    $(document).ready(function() {
        $.ajax({
            url: "http://localhost:8080/convert",
            data: {
                cur1: document.getElementById('cur1').value,
                val1: document.getElementById('val1').value,
                cur2: document.getElementById('cur2').value
            }
        }).then(function(data, status, jqxhr) {
            $('.result-content').text(data.result)
            console.log(jqxhr)
        })
    })
}