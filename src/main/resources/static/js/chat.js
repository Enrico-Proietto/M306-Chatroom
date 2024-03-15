const CHAT_ID_PARAM_PREFIX = 'chatID=';
let currentChatId = null;

document.addEventListener('DOMContentLoaded', function () {
    setInterval(fetchChatData, 500);

    currentChatId = retrieveChatIdFromCurrentUrl();
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

function fetchChatData() {
    if (currentChatId !== null) {
        let chatMessagesContainer = document.getElementById('chat-messages');

        let xmlHttpRequest = new XMLHttpRequest();

        xmlHttpRequest.onreadystatechange = function () {
            if (this.readyState === 4) {
                if (this.status === 200) {
                    chatMessagesContainer.innerHTML = this.responseText;
                } else {
                    console.log("Oh no!!!")
                }
            }
        };

        xmlHttpRequest.open("GET", "/chat/messages?chatID=" + currentChatId, true);
        xmlHttpRequest.send();
    }
}
