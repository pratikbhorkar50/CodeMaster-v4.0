//******************************* */
// Please install npm package to run this indx.js file--> npm install --save n-readlines
//******************************* */

var fs = require("fs");
const readLine = require('readline');

var logger = fs.createWriteStream('Problem1_output.txt')


const lineByLine = require('n-readlines');
const liner = new lineByLine('Problem1_input.txt');

let totTrips = liner.next().toString();

while (totTrips > 0){
    let totDistance;
    let totVehicle;
    let mySpeed;
    let initData = liner.next().toString();
    totDistance = initData.slice(0, initData.indexOf(' ')+1);
    totVehicle = initData.slice(initData.indexOf(' ')+1);


    initData = liner.next().toString();
    let vehicleRemDis = totDistance - initData.slice(0, initData.indexOf(' ')+1);
    let minVehicleSpeed = initData.slice(initData.indexOf(' ')+1);
    for(let i=1; i<totVehicle; i++){
        initData = liner.next().toString();
        if(initData.slice(initData.indexOf(' ')+1) < minVehicleSpeed){
            minVehicleSpeed = initData.slice(initData.indexOf(' ')+1);
            vehicleRemDis = totDistance - initData.slice(0, initData.indexOf(' ')+1);

        }
    }

    mySpeed = (totDistance) / (vehicleRemDis/minVehicleSpeed);

    console.log(mySpeed);
    logger.write(mySpeed+'\n');
    totTrips--;

}