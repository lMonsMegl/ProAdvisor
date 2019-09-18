import React, { Component } from 'react';
import PropTypes from 'prop-types';

const imageMaxSize = 10000000000;
const acceptedFileTypes = 'image/x-png, image/png, image/jgp, image/jpeg, image/gif';
const acceptedFileTypesArray = acceptedFileTypes.split(',').map(item => item.trim());

class DropAndChooseImages extends Component {
  static propTypes = {
    onSetImage: PropTypes.func,
    onDeleteImage: PropTypes.func,
    image: PropTypes.any
  };

  // verifyFile = file => {
  //   if (file) {
  //     const currentFileType = file.type;
  //     const currentFileSize = file.size;
  //
  //     if (currentFileSize > imageMaxSize) {
  //       alert(`This file is not allowed. ${currentFileSize} bytes is too large.`);
  //       return false;
  //     }
  //     if (!acceptedFileTypesArray.includes(currentFileType)) {
  //       alert('This file is not allowed. Only images are allowed.');
  //       return false;
  //     }
  //     return true;
  //   }
  // };

  onAddImage = file => {

    if (file) {
      // const isVerified = this.verifyFile(file);
      // if (isVerified) {
      //   const reader = new FileReader();
      //   reader.addEventListener('load', () => {
      // const newImage = <img className="carousel-image" alt="" src={reader.result} />;

      this.props.onSetImage(file);
      //     }, false);
      //
      //     reader.readAsDataURL(file);
      //   }
      // }
    }
  };

  render() {
    const { image } = this.props;
    console.log(image);

    return (
        <div className="photo">
          <div className="photo-container">
            <div className="images">
              {image && <div className="imageContainer">
                <img alt="" className="mainImage" src={image.props.src} />
                <button type="button" className="button-without-styles" onClick={this.props.onDeleteImage}>
                  <i className="far fa-times-circle fa-2x deleteImage" />
                </button>
              </div>}
              <input type="file"
                     title="Click to upload image"
                     onChange={e => this.onAddImage(e.target.files[0])} />

            </div>
          </div>
        </div>
    );
  }
}

export default DropAndChooseImages;
