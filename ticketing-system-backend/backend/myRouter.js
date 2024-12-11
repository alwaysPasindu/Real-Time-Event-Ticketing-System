// routes/myRouter.js
const express = require('express');
const router = express.Router();

// Define your routes
router.get('/tickets', (req, res) => {
    res.json({ message: 'Here are all the tickets!' });
});

// Export the router
module.exports = router;
