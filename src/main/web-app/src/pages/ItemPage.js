import React, { Component } from 'react';
import PropTypes from 'prop-types';
import { connect } from 'react-redux';
import cateringImage from '../assets/catering.jpg';
import AppHeader from '../components/AppHeader';
import { Link } from 'react-router-dom';
import { getCurrentCateringMenu, loading, setCurrentCatering } from '../actions/store/caterings';
import { addItemComment } from '../actions/request/comments';

class ItemPage extends Component {
  static propTypes = {
    current: PropTypes.object,
    getCateringMenu: PropTypes.func
  };

  constructor(props) {
    super(props);
    this.state = {
      commentTitle: '',
      commentText: '',
      commentRating: ''
    };
  }

  onShowMenu = () => {
    this.props.getCateringMenu(this.props.current.id);
  };

  onAddComment = () => {
    const { commentTitle, commentText, commentRating } = this.state;
    if (commentRating !== '' && commentText !== '' && commentTitle !== '') {
      addItemComment(this.props.current.id, {
        title: commentTitle,
        text: commentText,
        rating: parseInt(commentRating)
      })
          .then(() => {
            this.setState({
              commentTitle: '',
              commentText: '',
              commentRating: ''
            });
            this.props.setCurrent(this.props.current.id);
          });
    }
  };

  render() {

    return (
        <div className="page">
          <AppHeader />
          {
            !this.props.loading &&
            <div className="catering-page">
              <div className="padding" />
              <div className="catering">
                <div key={this.props.current.name} className="catering">
                  <h5>{this.props.current.name}</h5>
                  <div className="catering-menu-preview">
                    Rating : {this.props.current.rating.toFixed(1)} |
                    <Link className="link small-padding-left" to="/catering-menu" onClick={this.onShowMenu}>
                      Menu
                    </Link>
                  </div>
                  <img alt="" className="dish-image" src={this.props.current.mainImage ? `http://localhost:9000/images/${this.props.current.mainImage }`: cateringImage} />

                  <div className="description">
                    <h6 className="description-title">Description</h6>
                    <div>
                      {this.props.current.description}
                    </div>
                  </div>

                  <div className="comments">
                    <h6>Comments</h6>
                    {
                      this.props.name !== '' &&
                      <div className="add-comment">
                        <div className="user">
                          <i className="far fa-user fa-half" />
                          <div>
                            {this.props.name}
                          </div>
                        </div>
                        <div className="comment-text">
                          <div className="left">
                        <textarea placeholder="Title..."
                                  value={this.state.commentTitle}
                                  onChange={event => this.setState({ commentTitle: event.target.value })}
                                  className="left comment-title"
                                  maxLength="70" />
                            {this.state.commentTitle === '' &&
                            <div className="error-message">This field can not be empty</div>}
                          </div>
                          <div className="left comment-rating">
                            <input type="number"
                                   value={this.state.commentRating}
                                   onChange={event => this.setState({ commentRating: event.target.value })}
                                   className="left"
                                   placeholder="Rating" />
                            {this.state.commentRating === '' &&
                            <div className="error-message">This field can not be empty</div>}
                          </div>
                          <div className="left">
                        <textarea placeholder="Comment..."
                                  value={this.state.commentText}
                                  onChange={event => this.setState({ commentText: event.target.value })}
                                  className="comment-description"
                                  maxLength="500" />
                            {this.state.commentText === '' &&
                            <div className="error-message">This field can not be empty</div>}
                          </div>
                          <div className="right">
                            <button type="button" className="btn btn-danger" onClick={this.onAddComment}>
                              Add comment
                            </button>
                          </div>
                        </div>
                      </div>
                    }
                    <div className="other-users-comments">
                      {
                        this.props.current.comments && this.props.current.comments.map(comment =>
                            <div className="add-comment" key={comment.id + comment.title}>
                              <div className="user">
                                <i className="far fa-user fa-half" />
                                <div>
                                  {comment.user.username}
                                </div>
                              </div>
                              <div className="comment-text">
                                <div className="left">
                                  {comment.title}
                                </div>
                                <div className="left comment-rating">
                                  {comment.rating}
                                </div>
                                <div className="left">
                                  {comment.text}
                                </div>

                              </div>
                            </div>
                        )
                      }
                    </div>

                  </div>

                </div>
              </div>
              < div className='padding' />
            </div>
          }
        </div>
    );
  }
}

const mapStateToProps = store => ({
  current: store.caterings.current,
  loading: store.caterings.loading,
  name: store.user.username,
  menuData: store.languages.menuData
});

const mapDispatchToProps = dispatch => ({
  getCateringMenu: id => dispatch(getCurrentCateringMenu(id)),
  setCurrent: id => dispatch(setCurrentCatering(id)),
  loadCatering: flag => dispatch(loading(flag))
});

export default connect(
    mapStateToProps,
    mapDispatchToProps
)(ItemPage);
