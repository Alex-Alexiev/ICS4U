const SerialPort = require('serialport')
const Readline = require("@serialport/parser-readline")

const port = new SerialPort('COM5', {
    baudRate: 9600
})

const parser = port.pipe(new Readline({
    delimiter: '\n'
}))

port.on("open", () => {
    console.log("open")
})

parser.on("data", data => {
    console.log(data)
})

