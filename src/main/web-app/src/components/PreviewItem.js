import React, { Component } from 'react';
import { setCurrentCatering, loading } from '../actions/store/caterings';
import PropTypes from 'prop-types';
import { connect } from 'react-redux';
import { Link } from 'react-router-dom';

class PreviewItem extends Component {
  static propTypes = {
    title: PropTypes.string.isRequired,
    description: PropTypes.string.isRequired,
    rating: PropTypes.number,
    image: PropTypes.any.isRequired,
    setCurrent: PropTypes.func,
    loadCatering: PropTypes.func,
    id: PropTypes.number.isRequired
  };

  onSelectCatering = () => {
    this.props.loadCatering(true);
    this.props.setCurrent(this.props.id);
  };

  render() {
    const { image, rating, description, title } = this.props;
    return (
        <div className="catering-preview">
          <Link className="link" to="/item" onClick={this.onSelectCatering}>
            <img className="preview-catering-image" alt={`catering-${title}`} src={image} />
          </Link>
          <div className="catering-preview-info">
            <Link className="link" style={{ textDecoration: 'none' }} to="/item"
                  onClick={this.onSelectCatering}>
              <div className="preview-title">{title}</div>
            </Link>
            <div>{rating}</div>
            <div className="preview-description">{description}</div>
          </div>
        </div>
    );
  }
}

export default connect(
    null,
    dispatch => ({
      setCurrent: id => dispatch(setCurrentCatering(id)),
      loadCatering: flag => dispatch(loading(flag))
    })
)(PreviewItem);
