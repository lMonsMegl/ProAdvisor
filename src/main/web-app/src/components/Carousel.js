import React, { Component } from 'react';
import AliceCarousel from 'react-alice-carousel';
import PropsTypes from 'prop-types';

class Carousel extends Component {
  static propTypes = {
    images: PropsTypes.arrayOf(Object).isRequired
  };

  state = {
    currentIndex: 0,
    itemsInSlide: 1,
    responsive: {
      0: { items: 1 },
      1024: { items: 2 }
    }
  };

  handleOnSlideChange = (event) => {
    const { itemsInSlide, item } = event;
    this.setState({ itemsInSlide, currentIndex: item });
  };

  render() {
    const { currentIndex, responsive } = this.state;
    const { images } = this.props;

    return (
        <AliceCarousel
            items={images}
            slideToIndex={currentIndex}
            responsive={responsive}
            swipeDisabled={true}
            buttonsDisabled={true}
            onInitialized={this.handleOnSlideChange}
            onSlideChanged={this.handleOnSlideChange}
            onResized={this.handleOnSlideChange}
        />
    );
  }
}

export default Carousel;
