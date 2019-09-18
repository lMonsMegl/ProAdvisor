import React, { Component } from 'react';
import { connect } from 'react-redux';
// import PropTypes from 'prop-types';
import AppHeader from '../components/AppHeader';
import PreviewItem from '../components/PreviewItem';
import cateringImage from '../assets/catering.jpg';

class ItemsPageWithFilters extends Component {
  render() {
    const { items } = this.props;
    return (
        <div className="page">
          <AppHeader />
          <div className="items-page">
            <div className="padding" />
            <div className="caterings-list">
              {
                items && items.map(catering => {
                  console.log(catering);
                  const image = catering.mainImage ?  `http://localhost:9000/images/${catering.mainImage}` : cateringImage;
                  return (<PreviewItem title={catering.name}
                                       id={catering.id}
                                       key={catering.id + catering.name}
                                       description={catering.description}
                                       image={image}
                                       rating={catering.rating} />);
                })
              }
            </div>
            <div className="padding" />
          </div>
        </div>
    );
  }
}

export default connect(
    store => ({
      items: store.categories.currentCategoryItems
    })
)(ItemsPageWithFilters);
