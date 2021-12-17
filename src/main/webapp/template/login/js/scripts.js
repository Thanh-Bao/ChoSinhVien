var count=0;
function handleFileSelect(evt) {
    var $fileUpload = $("input#files[type='file']");
    count=count+parseInt($fileUpload.get(0).files.length);
    
    if (parseInt($fileUpload.get(0).files.length) > 6 || count>5) {
        alert("You can only upload a maximum of 5 files");
        count=count-parseInt($fileUpload.get(0).files.length);
        evt.preventDefault();
        evt.stopPropagation();
        return false;
    }
    var files = evt.target.files;
    for (var i = 0, f; f = files[i]; i++) {
        if (!f.type.match('image.*')) {
            continue;
        }
        var reader = new FileReader();

        reader.onload = (function (theFile) {
            return function (e) {
                var span = document.createElement('span');
                span.innerHTML = ['<img class="thumb" src="', e.target.result, '" title="', escape(theFile.name), '"/><span class="remove_img_preview"></span>'].join('');
                document.getElementById('list-select-img').insertBefore(span, null);
            };
        })(f);

        reader.readAsDataURL(f);
    }
}

$('#files').change(function(evt){
    handleFileSelect(evt);
});	 

$('#list-select-img').on('click', '.remove_img_preview',function () {
    $(this).parent('span').remove();
    
    //this is not working...
    var i = array.indexOf($(this));
    if(i != -1) {
        array.splice(i, 1);
    }
    // tried this too:
    //$(this).parent('span').splice( 1, 1 );
    
    count--;
});

$(document).ready(function() {
    $('a#heart').click(function() {
      $(this).toggleClass("heart-luu");
    });
  });