import React, { Component } from 'react';
import AppHeader from '../components/AppHeader';
import { connect } from 'react-redux';
import { getAllCateringsPreview } from '../actions/store/caterings';
import PropTypes from 'prop-types';
import PreviewItem from '../components/PreviewItem';
import cateringImage from '../assets/catering.jpg';
import dishPhoto from '../assets/dish.jpg';

class HomePage extends Component {
  static propTypes = {
    caterings: PropTypes.array,
    getCaterings: PropTypes.func
  };

  componentDidMount() {
    this.props.getCaterings();
  }

  render() {
    const { caterings } = this.props;

    return (
        <div className="page">
          <AppHeader />
          <div className="catalog-page">
            <div className="padding" />
            <div className="caterings-list">
              {
                caterings && caterings.map(catering =>
                    <PreviewItem title={catering.name}
                                 id={catering.id}
                                 key={catering.id + catering.name}
                                 description={catering.description}
                                 image={catering.mainImage ?  `http://localhost:9000/images/${catering.mainImage}` : cateringImage}
                                 rating={catering.rating} />)
              }
            </div>
            <div className="padding" />
          </div>
        </div>
    );
  }
}

const mapStateToProps = store => ({
  caterings: store.caterings.caterings
});

const mapDispatchToProps = dispatch => ({
  getCaterings: () => dispatch(getAllCateringsPreview())
});

export default connect(
    mapStateToProps,
    mapDispatchToProps
)(HomePage);
