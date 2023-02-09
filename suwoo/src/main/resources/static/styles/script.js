document.querySelector("#files").addEventListener("change", (e) => {
    if (window.File && window.FileReader && window.FileList && window.Blob) {
      const files = e.target.files;
      const output = document.querySelector("#result");
      output.innerHTML = "";
      for (let i = 0; i < files.length; i++) {
         if (!files[i].type.match("image")) continue;
          const picReader = new FileReader();
          picReader.addEventListener("load", function (event) {
            const picFile = event.target;
            const div = document.createElement("div");
            div.innerHTML = `<img class="thumbnail" src="${picFile.result}" title="${picFile.name}"/>`;
            output.appendChild(div);
          });
          picReader.readAsDataURL(files[i]);
         }
    } else {
      alert("Your browser does not support File API");
    }
  });
  function functionDis(id){
              console.log(id)
              document.getElementById("img"+id).setAttribute('disabled', '');
              document.getElementById("img"+id).setAttribute('hidden', '');
              document.getElementById(id).setAttribute('disabled', '');
              document.getElementById(id).setAttribute('hidden', '');
              document.getElementById(id).style.display = "none";
              document.getElementById("id"+id).setAttribute('disabled', '');
              document.getElementById("id"+id).setAttribute('hidden', '');
              document.getElementById("url"+id).setAttribute('disabled', '');
              document.getElementById("url"+id).setAttribute('hidden', '');
   }

