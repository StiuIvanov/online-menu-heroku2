action();


function action() {
    let btn = document.querySelector('body > header > div > nav > div > button');
    btn.addEventListener('click', removeStyleHeight);
}


function removeStyleHeight() {
    let navID = document.getElementById('navbar');

    if (navID.classList.contains('toggleOff')) {
        toggleOn(navID);
    } else {
        setTimeout(function(){
            navID.style.height = '2px';
            navID.classList.replace('toggleOn', 'toggleOff');
        },350);
    }
}

function toggleOn(navID) {
    navID.style.height = null
    navID.classList.replace('toggleOff', 'toggleOn');
}


