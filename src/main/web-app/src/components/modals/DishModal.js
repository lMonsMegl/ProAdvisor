import React, { Component } from 'react';
import PropTypes from 'prop-types';
import { addDish } from '../../actions/request/caterings';

const imageMaxSize = 10000000000;
const acceptedFileTypes = 'image/x-png, image/png, image/jgp, image/jpeg, image/gif';
const acceptedFileTypesArray = acceptedFileTypes.split(',').map(item => item.trim());

class DishModal extends Component {
  static propTypes = {
    id: PropTypes.number.isRequired,
    currentChapter: PropTypes.string.isRequired,
    currentSubChapter: PropTypes.string.isRequired,
    update: PropTypes.func.isRequired
  };

  constructor(props) {
    super(props);
    this.state = {
      newDishName: '',
      newDishPrice: '',
      newDishDescription: '',
      newDishIngredients: '',
      newDishWeight: '',
      image: ''
    };
  }

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
  //
  // onAddImage = file => {
  //   if (file) {
  //     const isVerified = this.verifyFile(file);
  //     if (isVerified) {
  //       const reader = new FileReader();
  //       reader.addEventListener('load', () => {
  //         const newImage = <img className="carousel-image" alt="" src={reader.result} />;
  //
  //         this.setState({ image: newImage });
  //       }, false);
  //
  //       reader.readAsDataURL(file);
  //     }
  //   }
  // };

  onAddDish = () => {
    console.log(this.state.image);
    const fields = [
      this.state.newDishName,
      this.state.newDishPrice,
      this.state.newDishDescription,
      this.state.newDishIngredients,
      this.state.newDishWeight,
      this.state.image
    ];

    // fields.every(field => field !== '') &&
    addDish(this.props.id, this.props.currentChapter, this.props.currentSubChapter, {
      name: this.state.newDishName,
      description: this.state.newDishDescription,
      ingredients: this.state.newDishIngredients,
      price: this.state.newDishPrice,
      weight: this.state.newDishWeight,
      image: this.state.image
    })
        .then(() => this.props.update());
  };

  render() {
    const { newDishName, newDishPrice, newDishDescription, newDishIngredients, newDishWeight } = this.state;

    return (
        <div className="modal fade" id="addDishModal" tabIndex="-1" role="dialog"
             aria-labelledby="addDishModalLabel" aria-hidden="true">
          <div className="modal-dialog" role="document">
            <div className="modal-content">
              <div className="modal-header">
                <h5 className="modal-title" id="addDishModalLabel">Add Dish</h5>
                <button type="button" className="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>

              <div className="modal-body">
                <div className="register-input">
                  <input type="text"
                         placeholder="Dish Name..."
                         value={newDishName}
                         onChange={event => this.setState({ newDishName: event.target.value })} />
                  <div className="error-message">{newDishName === '' && 'This field is required'}</div>
                </div>

                <div className="register-input">
                  <input type="number"
                         placeholder="Dish Price..."
                         value={newDishPrice}
                         onChange={event => this.setState({ newDishPrice: event.target.value })} />
                  <div className="error-message">{newDishPrice === '' && 'This field is required'}</div>
                </div>

                <div className="register-input">
                  <input type="text"
                         placeholder="Dish Description..."
                         value={newDishDescription}
                         onChange={event => this.setState({ newDishDescription: event.target.value })} />
                  <div className="error-message">{newDishDescription === '' && 'This field is required'}</div>
                </div>

                <div className="register-input">
                  <input type="text"
                         placeholder="Dish Ingredients..."
                         value={newDishIngredients}
                         onChange={event => this.setState({ newDishIngredients: event.target.value })} />
                  <div className="error-message">{newDishIngredients === '' && 'This field is required'}</div>
                </div>

                <div className="register-input">
                  <input type="number"
                         placeholder="Dish Weight..."
                         value={newDishWeight}
                         onChange={event => this.setState({ newDishWeight: event.target.value })} />
                  <div className="error-message">{newDishWeight === '' && 'This field is required'}</div>
                </div>

                <div className="register-input">
                  <input type="file"
                         title="Click to upload image"
                         onChange={e => this.setState({image: e.target.files[0]})} />
                  <div className="error-message">{this.state.image === '' && 'This field is required'}</div>
                </div>
              </div>

              <div className="modal-footer">
                <button type="button" className="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button"
                        className="btn btn-primary"
                        data-dismiss={this.state.newDishName !== '' && 'modal'}
                        onClick={this.onAddDish}>
                  Add
                </button>
              </div>
            </div>
          </div>
        </div>
    );
  }
}

export default DishModal;
