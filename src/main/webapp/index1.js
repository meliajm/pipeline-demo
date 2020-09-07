let url = 'http://localhost:8080/project1/';

document.getElementById('financeM').style.display='none';
document.getElementById('employee').style.display='none';
document.getElementById('logoutbtn').style.display='none';
document.getElementById('table-row').style.display='none';
// document.getElementById('submitReimb').style.display='none';
let resolver = document.getElementById('resolver').value;


document.getElementById("loginbtn").addEventListener("click", loginFunc);
document.getElementById("logoutbtn").addEventListener("click", logoutFunc);
document.getElementById('filterStatusBtn').addEventListener("click", queryReimb);
document.getElementById('SelectBtn').addEventListener("click", selectReimb);
document.getElementById('submitReimb').addEventListener("click", submitReimb);

document.getElementById('UpdateBtn').addEventListener("click", updateReimb);

amountCheck = (amount) => {
    
    amount.toString().split('.')[1].length

}

async function submitReimb() {
    let amount = document.getElementById('reimbAmount').value;
    // amountCheck(amount);
    lengthOfDecimals = amount.toString().split('.')[1].length;

    let descr = document.getElementById('reimbDesc').value;
    
    let type = document.getElementById('type').value;
    // if (type==='Lodging') {
    //     typeObj = {"reimbTypeID": 1, "reimbType": "Lodging"}
    // } else if (type==='Food') {
    //     typeObj = {"reimbTypeID": 4, "reimbType": "Food"}        
    // } else if (type==='Other') {
    //     typeObj = {"reimbTypeID": 2, "reimbType": "Other"}        
    // } else if (type==='Travel') {
    //     typeObj = {"reimbTypeID": 3, "reimbType": "Travel"}        
    // } 

    //get username from session somewhere, cookie or something?
    if (lengthOfDecimals===2 && amount>0) {
        let reimb = {
            reimbAmount: amount,
            reimbDescription: descr,
            reimbAuthorString: "tiaclair1",
            reimbResolver: null,
            reimbStatus: "Pending",
            reimbType: type,
            timeResolved: null,
            timeSubmitted: new Date(),
        }

        console.log(reimb);

        let resp = await fetch(url+"reimbursement/", {
            method: 'POST',
            body: JSON.stringify(reimb),
            credentials: "include"
        })

        if (resp.status==201) {
            let tbody = document.getElementById('reimb-body');
            tbody.innerHTML= "";
            findAllFunc()
            document.getElementById('reimbAmount').value="";
            document.getElementById('reimbDesc').value="";
        } else {
            document.getElementById("login-row").innerText = 'Reimb was NOT added';
        }
    } else {
        console.log('that is not a proper value')
        document.getElementById("login-row").innerText = 'that is not a proper value';
        document.getElementById("login-row").style.color = 'red';
    }
}
// show all again
async function updateReimb() {
    let stat = document.getElementById('updateReimb').value;
    let reimbID = document.getElementById("reimbID").value;
    if (document.getElementById('link').innerHTML===reimbID&&document.getElementsByTagName('td').length!==1) {
        // console.log('updating reimb to '+ stat + 'with id of: ' +reimbID);
        //call get
        // let reimb = getReimb();

        let reimbID = document.getElementById("reimbID").value;
        console.log("you've picked this reimb id "+ reimbID);

        let response = await fetch(url+"reimbursement/"+reimbID+'/');

        if (response.status === 200) {
            console.log('getting');
            let reimb = await response.json();
            console.log("reimb");
            console.log(reimb);

            // let reimb = {
            //     reimbAmount: amount,
            //     reimbDescription: descr,
            //     reimbAuthorString: "tiaclair1",
            //     reimbResolver: null,
            //     reimbStatus: "Pending",
            //     reimbType: type,
            //     timeResolved: null,
            //     timeSubmitted: new Date(),
            // }

            let data = {
                reimbID: reimb.reimbID,
                reimbAmount: reimb.reimbAmount,
                reimbDescription: reimb.reimbDescription,
                reimbAuthorString: reimb.reimbAuthor.username,
                reimbResolver: resolver,
                reimbStatus: stat,
                reimbType: reimb.reimbType.reimbType,
                timeResolved: new Date(),
                timeSubmitted: reimb.timeSubmitted
            }

            let resp = await fetch(url+"reimbursement/"+reimbID+'/', {
                method: 'POST',
                body: JSON.stringify(data),
                credentials : "include"
            })

            // make reimbDTO here in java

            if (resp.status===202){
                document.getElementById("login-row").innerText = "Status is updated.";
                //reload all reimbs to display
                // showAll(data);
                let tbody = document.getElementById('reimb-body');
                tbody.innerHTML= "";
                findAllFunc();
            } else {
                document.getElementById("login-row").innerText = "That did not update";
            }
            reimbID="";
            stat="";

        } else {
            console.log('you are not able to get that record');
        }

    }
}

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

    if (resp.status===200){
        document.getElementById("login-row").innerText = "You have logged in "+user.username;
        console.log(`user: ${user.username}`);
        if (user.username==='captini'|| user.username==='captain' ||user.username==='liz') {
            resolver = user.username;
            document.getElementById('financeM').style.display='block';
            document.getElementById("login-row").style.color ="blue";
        } else {
            document.getElementById('employee').style.display='block';
        }
        findAllFunc();
        document.getElementById('table-row').style.display='block';
        document.getElementById('logoutbtn').style.display = "block";
        document.getElementById('logininput').style.display='none'
        document.getElementById("username").value="";
        document.getElementById("password").value="";
    } else {
        document.getElementById("login-row").innerText = "Login failed!";
        document.getElementById("login-row").style.color = "red";
    }
}

async function logoutFunc() {
    let resp = await fetch(url+"logout", {
        method: 'GET',
        credentials : "include"
    })
    if (resp.status===200){
        document.getElementById("login-row").innerText = "You have logged out";  
        document.getElementById('financeM').style.display='none';
        document.getElementById('employee').style.display='none';
        document.getElementById('logoutbtn').style.display='none';
        document.getElementById('reimb-body').innerHTML="";
        document.getElementById('logininput').style.display='inline';
        document.getElementById('table-row').style.display='none';
        document.getElementById("login-row").style.color ="black";
    } else {
        document.getElementById("login-row").innerText = "Logout somehow failed!";
        document.getElementById("login-row").style.color = "red";
    }
}

async function selectReimb() {

    let reimbID = document.getElementById("reimbID").value;
    console.log("you've picked this reimb id "+ reimbID);
    // document.getElementById('select').innerHTML = '';

    let response = await fetch(url+"reimbursement/"+reimbID+'/');

    if (response.status === 200) {
        let data = await response.json();
        console.log('data: '+data);
        let tbody = document.getElementById('reimb-body');
        tbody.innerHTML= "";
        let newRow = document.createElement('tr');
        let td1 = document.createElement('td');
        td1.id = "link"
        td1.innerText = data.reimbID; 
        td1.style.color = 'blue';
        
        let td2 = document.createElement('td');
        let td3 = document.createElement('td');
        let td4 = document.createElement('td');
        let td5 = document.createElement('td');
        let td6 = document.createElement('td');
        let td7 = document.createElement('td');

        td2.innerText = data.reimbAmount;
        if (data.timeSubmitted===null) {
            td3.innerText = "";
        } else {
            td3.innerText = data.timeSubmitted;
        }
        if (data.timeResolved===null) {
            td4.innerText = "";
        } else {
            td4.innerText = data.timeResolved;
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
    } else {
        console.log('that did not work');
    }
    // reimbID = document.getElementById("reimbID").value='';
}

async function queryReimb() {
    let query = document.getElementById("filterID").value;
    console.log(query);
    // document.getElementById('select').innerHTML = '';

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
        let tbody = document.getElementById('reimb-body');
        tbody.innerHTML= "";
        for (let i = 0; i < data.length; i++) {
            if (query===data[i].reimbStatus.reimbStatus) {

                console.log(data);

                let tbody = document.getElementById('reimb-body');
                console.log(data[i]);
                console.log("amount: "+data[i].reimbAmount);
                let newRow = document.createElement('tr');
                let td1 = document.createElement('td');
                td1.id = "link" 
                td1.innerText = data[i].reimbID; 
                td1.style.color = 'blue';
            
                let td2 = document.createElement('td');
                let td3 = document.createElement('td');
                let td4 = document.createElement('td');
                let td5 = document.createElement('td');
                let td6 = document.createElement('td');
                let td7 = document.createElement('td');

                td2.innerText = data[i].reimbAmount;
                if (data[i].timeSubmitted===null) {
                    td3.innerText = "";
                } else {
                    td3.innerText = data[i].timeSubmitted;
                }
                if (data[i].timeResolved===null) {
                    td4.innerText = "";
                } else {
                    td4.innerText = data[i].timeResolved;
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
                } else if (query==="All") {
                    // showAll(data);
                    let tbody = document.getElementById('reimb-body');
                    console.log(data[i]);
                    console.log("amount: "+data[i].reimbAmount);
                    let newRow = document.createElement('tr');
                    let td1 = document.createElement('td');
                    td1.id = "link" 
                    td1.innerText = data[i].reimbID; 
                    td1.style.color = 'blue';
                
                    let td2 = document.createElement('td');
                    let td3 = document.createElement('td');
                    let td4 = document.createElement('td');
                    let td5 = document.createElement('td');
                    let td6 = document.createElement('td');
                    let td7 = document.createElement('td');
    
                    td2.innerText = data[i].reimbAmount;
                    if (data[i].timeSubmitted===null) {
                        td3.innerText = "";
                    } else {
                        td3.innerText = data[i].timeSubmitted;
                    }
                    if (data[i].timeResolved===null) {
                        td4.innerText = "";
                    } else {
                        td4.innerText = data[i].timeResolved;
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
    // query = document.getElementById("filterID").value='';
}

showAll = (data) => {
    for (let i = 0; i < data.length; i++) {
    let tbody = document.getElementById('reimb-body');
                    console.log(data[i]);
                    console.log("amount: "+data[i].reimbAmount);
                    let newRow = document.createElement('tr');
                    let td1 = document.createElement('td');
                    td1.id = "link" 
                    td1.innerText = data[i].reimbID; 
                    td1.style.color = 'blue';
                
                    let td2 = document.createElement('td');
                    let td3 = document.createElement('td');
                    let td4 = document.createElement('td');
                    let td5 = document.createElement('td');
                    let td6 = document.createElement('td');
                    let td7 = document.createElement('td');
    
                    td2.innerText = data[i].reimbAmount;
                    if (data[i].timeSubmitted===null) {
                        td3.innerText = "";
                    } else {
                        td3.innerText = data[i].timeSubmitted;
                    }
                    if (data[i].timeResolved===null) {
                        td4.innerText = "";
                    } else {
                        td4.innerText = data[i].timeResolved;
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

async function findAllFunc() {
    // if (document.getElementsByTagName('td').length>=1) {

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
            for (let i = 0; i < data.length; i++) {
                let tbody = document.getElementById('reimb-body');
                console.log(data[i]);
                console.log("amount: "+data[i].reimbAmount);
                let newRow = document.createElement('tr');
                let td1 = document.createElement('td');
                td1.id = "link" 
                td1.innerText = data[i].reimbID; 
                td1.style.color = 'blue';
            
                let td2 = document.createElement('td');
                let td3 = document.createElement('td');
                let td4 = document.createElement('td');
                let td5 = document.createElement('td');
                let td6 = document.createElement('td');
                let td7 = document.createElement('td');

                td2.innerText = data[i].reimbAmount;
                if (data[i].timeSubmitted===null) {
                    td3.innerText = "";
                } else {
                    td3.innerText = data[i].timeSubmitted;
                }
                if (data[i].timeResolved===null) {
                    td4.innerText = "";
                } else {
                    td4.innerText = data[i].timeResolved;
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
// }

}