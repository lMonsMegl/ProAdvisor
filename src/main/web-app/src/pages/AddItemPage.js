import React, { Component } from 'react';
import AppHeader from '../components/AppHeader';
import DropAndChooseImages from '../components/DropAndChooseImages';
import { CATERINGS, DISHES, PRODUCT_ITEMS, SHOP_ITEMS, SHOWPLACES_ITEMS } from '../config/urls';
import Select from 'react-select';
import { postItemByCategory } from '../actions/request/categories';

const categories = [
  {
    label: 'Products',
    url: PRODUCT_ITEMS
  },
  {
    label: 'Showplaces',
    url: SHOWPLACES_ITEMS
  },
  {
    label: 'Stores',
    url: SHOP_ITEMS
  },
  {
    label: 'Caterings',
    url: CATERINGS
  },
  {
    label: 'Dishes',
    url: DISHES
  }
];

class AddItemPage extends Component {
  constructor(props) {
    super(props);
    this.state = {
      text: '',
      title: '',
      image: '',
      category: ''
    };
  }

  onSetImage = selectedImage => {
    this.setState({ image: selectedImage });
  };

  onDeleteImage = () => {
    this.setState({
      image: ''
    });
  };

  onAddItem = () => {
    const { image, category, title, text } = this.state;
    console.log(image);
    const emptyState = {};
    if (image !== '' && category !== '' && title !== '' && text !== '') {
      postItemByCategory(this.state.category.url, {
        name: this.state.title,
        image: this.state.image,
        description: this.state.text
      }).then(() => this.setState(emptyState));
    }
  };

  render() {
    return (
        <div className="page">
          <AppHeader />
          <div className="add-item-page">
            <div>Title</div>
            <div>
            <textarea className="title-input"
                      value={this.state.title}
                      maxLength={80}
                      onChange={e => this.setState({ title: e.target.value })} />
              {this.state.title === '' && <div className="error-message">This field is required</div>}
            </div>
            <div className="select-categories">
              <Select className="select"
                      options={categories}
                      value={this.state.category}
                      onChange={option => this.setState({ category: option })} />
            </div>
            {this.state.category === '' && <div className="error-message">This field is required</div>}

            <div className="get-item-image">
              <input type="file"
                     title="Click to upload image"
                     onChange={e => this.setState({ image: e.target.files[0] })} />
              {this.state.image === '' && <div className="error-message">This field is required</div>}
            </div>

            <div>Description</div>
            <div>
            <textarea className="description-input"
                      value={this.state.text}
                      maxLength={300}
                      onChange={e => this.setState({ text: e.target.value })} />
              {this.state.text === '' && <div className="error-message">This field is required</div>}

            </div>
            <div className="add-item-button">
              <button type="button" className="btn btn-primary" onClick={this.onAddItem}>Add Item</button>

            </div>
          </div>
        </div>
    );
  }
}

export default AddItemPage;
