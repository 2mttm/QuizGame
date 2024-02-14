let map;
let word;

document.getElementById('input-form').addEventListener('submit',
    function (event){
    event.preventDefault();

    let input = document.getElementById("player-input");

    checkAnswer(word, input.value);
    input.value = ""
})

function start() {
    getRandomWord().then(word => {
        appendWordCard(word)
    })
}
function clearData(){
    map = new Map
}

function checkAnswer(word, answer) {
    let card = document.querySelector(".card");
    revealAnswer(card)

    if(answer.valueOf() === word['italianPast'].valueOf()){
        card.classList.add("text-bg-success")
    } else {
        card.classList.add("text-bg-danger")
    }
    start()
}

async function getRandomWord() {
    const response = await fetch("http://localhost:8080/random");
    word = await response.json();
    return word;
}

function appendWordCard(word) {
    let cardsContainer = document.getElementById("cards-container");
    cardsContainer.prepend(createCardBlock(word))
}

function createCardBlock(word) {
    console.log(word)
    let card = document.createElement("div")
    card.className = "card"
    let cardHeader = document.createElement("div")
    cardHeader.className = "card-header fw-bold fs-4"
    cardHeader.innerText = word['italian']
    let cardBody = document.createElement("div")
    cardBody.className = "card-body"
    cardBody.innerText = word['italianPast'] + '\n' + word['russian']
    cardBody.hidden = true

    card.appendChild(cardHeader)
    card.appendChild(cardBody)

    return card
}
function revealAnswer(card){
    card.lastChild.hidden = false
}

// <div className="progress mt-1 mb-0" style="height: 7px;">
//     <div className="progress-bar bg-danger" role="progressbar" style="width: 40%" aria-valuenow="40" aria-valuemin="0"
//          aria-valuemax="100"></div>