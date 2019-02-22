const express = require('express')
const bodyParser = require('body-parser')
const cors = require('cors')
const morgan = require('morgan')

const app = express()
app.use(morgan('combined'))
app.use(bodyParser.json())
app.use(cors())

app.get('/contacts', (req, res) => {
    res.send(
      [{
        title: "a list of all the conacts",
        description: "this is the list"
      }]
    )
  })

app.listen(process.env.PORT || 8081)