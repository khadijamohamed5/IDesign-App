const express = require('express');
const cors = require('cors');
const app = express();

app.use(cors());

const movies = require('./data/movies');

app.get('/movies', (req, res) => {
  res.json(movies);
});

const PORT = 3000;
app.listen(PORT, () => {
  console.log(`API running on http://localhost:${PORT}`);
});
