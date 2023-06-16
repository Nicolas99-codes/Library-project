// Book created
const bookImageUpload = document.getElementById("bookImage");
const cropBtnDiv = document.getElementById("cropBtnContainer");
const cropBtn = document.getElementById("cropBtn");
const loader = document.getElementById("spinnerBookImg");

const image = document.getElementById("img-createbook");

image.onload = function () {
    console.log("Image loaded successfully!");
    loader.style.visibility = "hidden";
    image.style.opacity = 1;
};

image.onerror = function () {

};

image.style.opacity = 0.5;
loader.style.visibility = 'unset';
image.src = existingImage;

bookImageUpload.addEventListener("change", (event) => {
    const imagePreview = document.getElementById("img-createbook");
    if (cropper !== undefined) {
        cropper.destroy();
    }
    imagePreview.style.opacity = 0.5;
    loader.style.visibility = 'unset';
    const selectedFile = event.target.files[0];
    const reader = new FileReader();
    reader.addEventListener("load", (event) => {
        imagePreview.src = event.target.result;
        try {cropper = new Cropper(imagePreview, {
            aspectRatio: 1,
            viewMode: 1,
        });
        } catch (e) {
            console.log("Oh oh " + e);
        }
        cropBtn.addEventListener("click", () => {
            const canvas = cropper.getCroppedCanvas();
            canvas.toBlob((blob) => {
                imagePreview.src = URL.createObjectURL(blob);
                // Convert the blob to a data URL
                const reader2 = new FileReader();
                reader2.onload = function () {
                    document.getElementById('cropped-image-input').value = reader2.result;
                };
                reader2.readAsDataURL(blob);
                cropper.destroy();
            });
            cropBtnDiv.style.visibility = "hidden";
        });


        cropBtnDiv.style.visibility = "unset";
        imagePreview.style.opacity = 1;
        loader.style.visibility = 'hidden';
    });

    reader.addEventListener("error", function () {
        console.log("Error reading image", reader.error);
    });

    reader.readAsDataURL(selectedFile);
});