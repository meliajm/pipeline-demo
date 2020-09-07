let url = 'http://localhost:8080/project1/';

document.getElementById("loginbtn").addEventListener("click", loginFunc);
document.getElementById('filterStatusBtn').addEventListener("click", queryReimb);
document.getElementById('SelectBtn').addEventListener("click", selectReimb);
document.getElementById('UpdateBtn').addEventListener("click", updateReimb);

async function loginFunc() {
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    console.log(username);
    let user = {
        username : username,
        password : password
    }

    let resp = await fetch(url+"login", {
        method: 'POST',
        body: JSON.stringify(user),
        credentials : "include"
    })

    if(resp.status===200){
        document.getElementById("login-row").innerText = "YOU HAVE LOGGED IN "+user.username;
        // this is hardcoded and should be changed
        if (user.username==='captain' || user.username==='liz') {
            // createButtonWithid("findAllBtn", "Show All Employee Reimbursements", findAllFunc(user.username));
            // createButtonWithid("filterStatusBtn", "Filter Reimbursement By Status", queryReimb, 'filter');
            // createButtonWithid("updateReimb", "Update Selected Reimb", updateReimb, "select");

            findAllFunc(user.username);

        } else {
            // createButtonWithid("findAllBtn", "Show My Reimbursements", findAllFunc(user.usernam));
           findAllFunc(user.username);

            // createButtonWithid("addReimbBtn", "Submit New Request", showAddReimbForm, "to-add-reimb");
        }
    } else {
        document.getElementById("login-row").innerText = "Login failed!";
    }
}

async function selectReimb() {

    let reimbID = document.getElementById("select").value;
    console.log("you've picked this reimb id "+ reimbID);
    document.getElementById('select').innerHTML = '';

    let response = await fetch(url+"reimbursement/"+reimbID+'/');

    if(response.status === 200) {
        let data = await response.json();
        console.log(data);

    

    
    let tbody = document.getElementById('reimb-body');
    tbody.innerHTML= "";
    // console.log("amount: "+data[i].reimbAmount);
    let newRow = document.createElement('tr');
    let td1 = document.createElement('td');
    td1.id = "link"
    // let a = document.createElement('a');
    // let b = document.createElement('button');

    // a.href = "reimbursement/"+data[i].reimbID;  
    // a.innerText = data[i].reimbID; 
    td1.innerText = data.reimbID; 
    td1.style.color = 'blue';
    // td1.onclick = showGetReimb(data[i].reimbID);
    // b.onclick = showGetReimb;
    // td1.appendChild(b); 
    let td2 = document.createElement('td');
    let td3 = document.createElement('td');
    let td4 = document.createElement('td');
    let td5 = document.createElement('td');
    let td6 = document.createElement('td');
    let td7 = document.createElement('td');

    td2.innerText = data.reimbAmount;
    if (data.timeSubmitted===null) {
        td3.innerText = "not updated"
    } else {
        td3.innerText = data.timeSubmitted.hour
    }
    if (data.timeResolved===null) {
        td4.innerText = "not updated"
    } else {
        td4.innerText = data.timeResolved.hour;
    }
    td5.innerText = data.reimbDescription;
    td6.innerText = data.reimbType.reimbType
    td7.innerText = data.reimbStatus.reimbStatus;

    newRow.appendChild(td1);
    newRow.appendChild(td2);
    newRow.appendChild(td3);
    newRow.appendChild(td4);
    newRow.appendChild(td5);
    newRow.appendChild(td6);
    newRow.appendChild(td7);

    tbody.appendChild(newRow);
    updateStatusTo();
    } else {
        console.log('that did not work');
    }

}

// function updateStatusTo() {
//     let table = document.getElementById('table-row');
//     let div = document.createElement('div');
    // let b = document.createElement('button');

    // let br = document.createElement('br');
    // let statusInput = document.getElementById('status');

    
    // if (!statusInput) {
    //     // let h5 = document.createElement('h5');
    //     div.className = 'row';
    //     div.id = 'reimb-to-uptdate-status';
    //     // h5.className = 'col-lg-12';
    //     // h5.innerText = "New status for reimbursement seleced? ";
    //     // h5.id = "change-status-to-this";
    //     let input = document.createElement('input');
    //     input.className = 'col-sm-4 form-control';
    //     input.id = 'status';
    //     input.type = 'text';
    //     input.value = 'Approved';
    //     input.placeholder = 'New status for reimbursement';
    //     // b.innerText = 'Update this';
    //     // b.id = 'updateReimbStatBtn'
    //     // b.onclick = updateReimb
    //     // div.appendChild(h5);
    //     div.appendChild(input);
    //     // div.appendChild(b);
    //     table.insertAdjacentElement('afterend', input);
    // }
// }

async function updateReimb() {
    stat = document.getElementById('status').value;
    if (document.getElementById('link').innerHTML===document.getElementById('reimbID').value
    ) {
        console.log('updating reimb to '+ stat);
        // do post here
    }
}

// function input(id, value, placeholder, idToAttachTo) {
//     let elem = document.getElementById(idToAttachTo);
//     let div = document.createElement('div');
//     // let h5 = document.createElement('h5');
//     // let br = document.createElement('br');
//     div.className = 'row';
//     div.id = 'reimb-to-uptdate-row';
//     // h5.className = 'col-lg-12';
//     // h5.innerText = "Please Enter The Remibursement ID you would like to update: ";
//     let input = document.createElement('input');
//     input.className = 'col-sm-4 form-control';
//     input.id = id;
//     input.type = 'text';
//     input.value = value;
//     input.placeholder = placeholder;
//     // div.appendChild(h5);
//     div.appendChild(input);

//     // row.appendChild(br);
//     elem.insertAdjacentElement('afterend', input);
// }

async function queryReimb() {

    // input('filter-query', 'Pending', 'Filter by Status', "filter")
    console.log('query reimb');

    const myHeaders = new Headers();
    myHeaders.append("Origin", "corssucklol");
    let resp = await fetch(url+"reimbursement", {
        credentials: 'include',
        headers: {
            Origin: "corssucks"
        }
      });

    if(resp.status===200){
        let data = await resp.json();
        console.log(data);
        
        // addReimbContent(data);
        for (let i = 0; i < data.length; i++) {
            let tbody = document.getElementById('reimb-body');
            console.log(data[i]);
            console.log("amount: "+data[i].reimbAmount);
            let newRow = document.createElement('tr');
            let td1 = document.createElement('td');
            td1.id = "link"
            // let a = document.createElement('a');
            // let b = document.createElement('button');

            // a.href = "reimbursement/"+data[i].reimbID;  
            // a.innerText = data[i].reimbID; 
            td1.innerText = data[i].reimbID; 
            td1.style.color = 'blue';
            // td1.onclick = showGetReimb(data[i].reimbID);
            // b.onclick = showGetReimb;
            // td1.appendChild(b); 
            let td2 = document.createElement('td');
            let td3 = document.createElement('td');
            let td4 = document.createElement('td');
            let td5 = document.createElement('td');
            let td6 = document.createElement('td');
            let td7 = document.createElement('td');

            td2.innerText = data[i].reimbAmount;
            if (data[i].timeSubmitted===null) {
                td3.innerText = "not updated"
            } else {
                td3.innerText = data[i].timeSubmitted.hour
            }
            if (data[i].timeResolved===null) {
                td4.innerText = "not updated"
            } else {
                td4.innerText = data[i].timeResolved.hour;
            }
            td5.innerText = data[i].reimbDescription;
            td6.innerText = data[i].reimbType.reimbType
            td7.innerText = data[i].reimbStatus.reimbStatus;

            newRow.appendChild(td1);
            newRow.appendChild(td2);
            newRow.appendChild(td3);
            newRow.appendChild(td4);
            newRow.appendChild(td5);
            newRow.appendChild(td6);
            newRow.appendChild(td7);

            tbody.appendChild(newRow);
          }
    }
}



async function findAllFunc(username) {
    // if (!!document.getElementById('findAllBtn')) {
    //     document.getElementById('findAllBtn').style.display = 'none';
    // }
    const myHeaders = new Headers();
    myHeaders.append("Origin", "corssucklol");
    let resp = await fetch(url+"reimbursement", {
        credentials: 'include',
        headers: {
            Origin: "corssucks"
        }
      });

    if(resp.status===200){
        let data = await resp.json();
        console.log(data);
        
        // addReimbContent(data);
        for (let i = 0; i < data.length; i++) {
            let tbody = document.getElementById('reimb-body');
            console.log(data[i]);
            console.log("amount: "+data[i].reimbAmount);
            let newRow = document.createElement('tr');
            let td1 = document.createElement('td');
            td1.id = "link"
            // let a = document.createElement('a');
            // let b = document.createElement('button');

            // a.href = "reimbursement/"+data[i].reimbID;  
            // a.innerText = data[i].reimbID; 
            td1.innerText = data[i].reimbID; 
            td1.style.color = 'blue';
            // td1.onclick = showGetReimb(data[i].reimbID);
            // b.onclick = showGetReimb;
            // td1.appendChild(b); 
            let td2 = document.createElement('td');
            let td3 = document.createElement('td');
            let td4 = document.createElement('td');
            let td5 = document.createElement('td');
            let td6 = document.createElement('td');
            let td7 = document.createElement('td');

            td2.innerText = data[i].reimbAmount;
            if (data[i].timeSubmitted===null) {
                td3.innerText = "not updated"
            } else {
                td3.innerText = data[i].timeSubmitted.hour
            }
            if (data[i].timeResolved===null) {
                td4.innerText = "not updated"
            } else {
                td4.innerText = data[i].timeResolved.hour;
            }
            td5.innerText = data[i].reimbDescription;
            td6.innerText = data[i].reimbType.reimbType
            td7.innerText = data[i].reimbStatus.reimbStatus;

            newRow.appendChild(td1);
            newRow.appendChild(td2);
            newRow.appendChild(td3);
            newRow.appendChild(td4);
            newRow.appendChild(td5);
            newRow.appendChild(td6);
            newRow.appendChild(td7);

            tbody.appendChild(newRow);
          }
    }
    if (username==='captain' || username==='liz') {
        // createButtonWithid("updateStatusBtn", "Select Reimbursement", selectReimb, "select");
        // reimbToUpdate();
    }


}

function reimbToUpdate() {
    // return `
    // <div class="row" id="reimb-to-uptdate-row">
    //         <h5 class="col-lg-12">Please Enter The Remibursement ID you would like to update:</h5>
    //         <input class="col-sm-4 form-control" id="reimbID" type="text" value="2" >
    // </div>
    // `
    // let table = document.getElementById('table-row');
    // let div = document.createElement('div');
    // // let h5 = document.createElement('h5');
    // // let br = document.createElement('br');
    // div.className = 'row';
    // div.id = 'reimb-to-uptdate-row';
    // // h5.className = 'col-lg-12';
    // // h5.innerText = "Please Enter The Remibursement ID you would like to update: ";
    // let input = document.createElement('input');
    // input.className = 'col-sm-4 form-control';
    // input.id = 'reimbID';
    // input.type = 'text';
    // input.value = '2';
    // input.placeholder = "Pick reimbursement id";
    // // div.appendChild(h5);
    // div.appendChild(input);

    // // row.appendChild(br);
    // table.insertAdjacentElement('afterend', input);
}

// function createButtonWithid(id, buttonText, func, idToAttach) {
//     // put buttons on two diff elements
//     let button = document.createElement('button');
//         button.className = "btn btn-success";
//         button.id = id;
//         button.innerText = buttonText;
//         button.onclick=func;
//         document.getElementById(idToAttach).appendChild(button);
// }

// function showAddReimbForm() {
//     let row = document.getElementById("to-add-reimb");
//     let div = document.createElement('div');
//     let addReimbBtn = document.getElementById('addReimbBtn');
//     // addReimbBtn.style.display = 'none';
//     let br = document.createElement('br');
//     div.className = 'row';
//     div.id = 'add-reimb-row';
//     let input1 = document.createElement('input');
//     input1.className = 'col-sm-4 form-control';
//     input1.name = 'amount';
//     input1.id = 'amount';
//     input1.placeholder = 'amount';
//     input1.type = 'text';
//     input1.value = '100.05';

//     row.appendChild(div);
//     row.appendChild(br);
//     div.insertAdjacentElement('afterend', input1);

//     let input2 = document.createElement('input');
//     input2.className = 'col-sm-4 form-control';
//     input2.name = 'time-submitted';
//     input2.id = 'time-submitted';
//     input2.placeholder = 'time submitted';
//     input2.type = 'text';
//     input2.value ='23:45:33'
//     input1.insertAdjacentElement('afterend', input2);

//     let input3 = document.createElement('input');
//     input3.className = 'col-sm-4 form-control';
//     input3.name = 'time-resolved';
//     input3.id = 'time-resolved';
//     input3.placeholder = 'time-resolved';
//     input3.type = 'text';
//     input3.value ='03:45:33'
//     input2.insertAdjacentElement('afterend', input3);

//     let input4 = document.createElement('input');
//     input4.className = 'col-sm-4 form-control';
//     input4.name = 'descr';
//     input4.id = 'descr';
//     input4.placeholder = 'descr';
//     input4.type = 'text';
//     input4.value ='this is for demos'
//     input3.insertAdjacentElement('afterend', input4);

//     let input5 = document.createElement('input');
//     input5.className = 'col-sm-4 form-control';
//     input5.name = 'author';
//     input5.id = 'author';
//     input5.placeholder = 'author';
//     input5.type = 'text';
//     input5.value = 'tiaclair1';
//     input4.insertAdjacentElement('afterend', input5);

//     let input6 = document.createElement('input');
//     input6.className = 'col-sm-4 form-control';
//     input6.name = 'resolver';
//     input6.id = 'resolver';
//     input6.placeholder = 'resolver';
//     input6.type = 'text';
//     input6.value = 'captain';
//     input5.insertAdjacentElement('afterend', input6);

//     let input7 = document.createElement('input');
//     input7.className = 'col-sm-4 form-control';
//     input7.name = 'status';
//     input7.id = 'status';
//     input7.placeholder = 'status';
//     input7.type = 'text';
//     input7.value = 'Pending';
//     input6.insertAdjacentElement('afterend', input7);

//     let input8 = document.createElement('input');
//     input8.className = 'col-sm-4 form-control';
//     input8.name = 'type';
//     input8.id = 'type';
//     input8.placeholder = 'type';
//     input8.type = 'text';
//     input8.value = 'Food';
//     input7.insertAdjacentElement('afterend', input8);

//     // let butn = document.createElement('button');
//     // butn.className = 'btn btn-success';
//     // butn.id = 'submit-reimb';
//     // butn.innerText = 'Submit your request';
//     // butn.onclick = submitReimb;
//     // input8.insertAdjacentElement('afterend', butn);

   
// }

async function submitReimb() {
    console.log('submitting your request')
    let amount = document.getElementById("amount").value;
    let timeSubmitted = document.getElementById("time-submitted").value;
    let timeResolved = document.getElementById("time-resolved").value;
    let descr = document.getElementById("descr").value;
    let author = document.getElementById("author").value;
    let resolver = document.getElementById("resolver").value;
    let status = document.getElementById("status").value;
    let type = document.getElementById("type").value;

    // console.log(username);
    let reimb = {
        reimbAmount : amount,
        timeSubmitted : timeSubmitted,
        timeResolved : timeResolved,
        reimbDescription : descr,
        reimbAuthor : author,
        reimbResolver : resolver,
        reimbStatus : status,
        reimbType : type 
    }

    let resp = await fetch(url+"add", {
        method: 'POST',
        body: JSON.stringify(reimb),
        credentials : "include"
    })

    if(resp.status===200){
        document.getElementById("login-row").innerText = "Your request has been successfully submitted "+user.username;
    } else {
        document.getElementById("login-row").innerText = "Your request has NOT been successfully submitted";
    }
}



