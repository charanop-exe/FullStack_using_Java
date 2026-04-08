const video = document.getElementById("videoPlayer");
const audio = document.getElementById("audioPlayer");

function playMedia() {
    video.play();
    audio.play();
}

function pauseMedia() {
    video.pause();
    audio.pause();
}

function stopMedia() {
    video.pause();
    audio.pause();
    video.currentTime = 0;
    audio.currentTime = 0;
}
