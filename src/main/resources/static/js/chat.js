const CHAT_ID_PARAM_PREFIX = 'chatID=';
let currentChatId = null;
let intervalTime = 500;

document.addEventListener('DOMContentLoaded', function () {
    setInterval(fetchChatData, intervalTime);

    currentChatId = retrieveChatIdFromCurrentUrl();
    intervalTime = 4000;
});

function retrieveChatIdFromCurrentUrl() {
    let currentUrl = window.location.href;

    if (currentUrl.includes('?')) {
        let parameters = currentUrl.split('?')[1];

        if (parameters.includes('&')) {
            let splitParameters = parameters.split('&');

            splitParameters.forEach(function (singleParamPair) {
                let cleanSingleParam = singleParamPair.replace('&', '');

                if (cleanSingleParam.includes(CHAT_ID_PARAM_PREFIX)) {
                    return cleanSingleParam.replace(CHAT_ID_PARAM_PREFIX, '');
                }
            });
        } else if (parameters.includes(CHAT_ID_PARAM_PREFIX)) {
            return parameters.replace(CHAT_ID_PARAM_PREFIX, '')
        }
    }

    return null;
}

/*
* Fetches chat data from the server and renders it on the page
* */
function fetchChatData() {
    if (currentChatId !== null) {
        let chatMessagesContainer = document.getElementById('chat-messages');

        let xmlHttpRequest = new XMLHttpRequest();

        xmlHttpRequest.onreadystatechange = function () {
            if (this.readyState === 4) {
                if (this.status === 200) {
                    chatMessagesContainer.innerHTML = renderChatMessages(this.responseText);
                } else {
                    console.log("Oh no!!!")
                }
            }
        };
        xmlHttpRequest.open("GET", "/chat/messages?chatID=" + currentChatId, true);
        xmlHttpRequest.send();
    }
}

function renderChatMessages(chatMessages) {

    let chatMessagesArray = JSON.parse(chatMessages);

    let html = '';
    chatMessagesArray.forEach(message => {
        html += `
            <div class="message">
                <div class="message-info">
                    <span class="author">${message.author.firstname} ${message.author.lastname}</span>
                    <span class="timestamp">${new Date(message.writtenAt).toLocaleString()}</span>
                </div>
                <div class="message-content">
                    <p>${message.text}</p>
                </div>
            </div>
        `;
    });
    return html;
}
