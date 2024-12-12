import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import Home from './pages/Home';
import Tickets from './pages/Tickets';
import Purchase from './pages/Purchase';
import Navbar from './components/Navbar';

const App = () => {
    return (
        <Router>
            <Navbar />
            <Switch>
                <Route path="/" exact component={Home} />
                <Route path="/tickets" component={Tickets} />
                <Route path="/purchase" component={Purchase} />
            </Switch>
        </Router>
    );
};

export default App;
