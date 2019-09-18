import React, { Component } from 'react';
import './styles/main.scss';
import HomePage from './pages/HomePage';
import { Route, Redirect, Switch } from 'react-router';
import CatalogPage from './pages/CatalogPage';
import AddItemPage from './pages/AddItemPage';
import CateringItem from './pages/ItemPage';
import { connect } from 'react-redux';
import PropTypes from 'prop-types';
import CateringMenuPage from './pages/CateringMenuPage';
import ItemsPage from './pages/ItemsPageWithFilters';

class App extends Component {
  static propTypes = {
    currentCatering: PropTypes.object
  };

  render() {
    return (
        <div className="App">
          <Switch>
            <Route exact path="/home" component={HomePage} />
            <Route exact path="/catalog" component={CatalogPage} />
            <Route exact path="/add-item" component={AddItemPage} />
            <Route exact path="/catalog/items" component={ItemsPage} />
            {(this.props.loading || this.props.current) &&
            <Switch>
              <Route exact path="/item" component={CateringItem} />
              <Route exact path="/catering-menu" component={CateringMenuPage} />
            </Switch>
            }
            <Redirect from="*" to="/home" />
          </Switch>
        </div>
    );
  }
}

export default connect(
    store => ({
      loading: store.caterings.loading,
      current: store.caterings.current,
      items: store.categories.currentCategoryItems
    })
)(App);
