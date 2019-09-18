import React, { Component } from 'react';
import AppHeader from '../components/AppHeader';
import { connect } from 'react-redux';
import productsImage from '../assets/products.jpg';
import showplacesImage from '../assets/showplaces.jpg';
import storesImage from '../assets/stores.jpg';
import cateringsImage from '../assets/caterings.jpg';
import dishesImage from '../assets/dishes.jpg';
import { SHOP_ITEMS, PRODUCT_ITEMS, SHOWPLACES_ITEMS, CATERINGS, DISHES } from '../config/urls';
import { getItemsByCategory } from '../actions/store/categories';
import { Link } from 'react-router-dom';

const categories = [
  {
    id: 1,
    name: 'Products',
    image: productsImage,
    url: PRODUCT_ITEMS
  },
  {
    id: 2,
    name: 'Showplaces',
    image: showplacesImage,
    url: SHOWPLACES_ITEMS
  },
  {
    id: 3,
    name: 'Stores',
    image: storesImage,
    url: SHOP_ITEMS
  },
  {
    id: 4,
    name: 'Caterings',
    image: cateringsImage,
    url: CATERINGS
  },
  {
    id: 5,
    name: 'Dishes',
    image: dishesImage,
    url: DISHES
  }
];

class CatalogPage extends Component {
  render() {
    return (
        <div className="page">
          <AppHeader />
          <div className="catalog-page">
            <div className="filters" />

            <div className="items">
              {categories.map(category =>
                  <div key={category.id} className="category">
                    <Link to="/catalog/items" onClick={() => this.props.getItems(category.url)}>
                      <img alt={`${category.id}-category`} src={category.image} />
                    </Link>
                    <Link to="/catalog/items" onClick={() => this.props.getItems(category.url)} >
                      <div className="category-title">{category.name}</div>
                    </Link>
                  </div>)}
            </div>

            <div className="filters" />
          </div>
        </div>
    );
  }
}

export default connect(
    null,
    dispatch => ({
      getItems: URL => dispatch(getItemsByCategory(URL))
    })
)(CatalogPage);
