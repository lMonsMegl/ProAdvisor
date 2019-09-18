import React, { Component } from 'react';
import PropTypes from 'prop-types';
import { connect } from 'react-redux';
import AppHeader from '../components/AppHeader';
import dishPhoto from '../assets/dish.jpg';
import ChapterModal from '../components/modals/ChapterModal';
import SubChapterModal from '../components/modals/SubChapterModal';
import DishModal from '../components/modals/DishModal';
import { getCurrentCateringMenu } from '../actions/store/caterings';

class CateringMenuPage extends Component {
  static propTypes = {
    menu: PropTypes.object,
    current: PropTypes.object,
    getCateringMenu: PropTypes.func
  };

  constructor(props) {
    super(props);
    this.state = {
      currentChapter: '',
      currentSubChapter: ''
    };
  }

  updateCateringMenu = () => {
    this.props.getCateringMenu(this.props.current.id);
  };

  render() {
    const { currentChapter, currentSubChapter } = this.state;

    return (
        <div className="page">
          <AppHeader />
          <div className="catering-menu-page">
            <div className="menu">
              <div className="menu-title">
                Menu
                <button type="button"
                        className="button-without-styles"
                        data-toggle="modal"
                        data-target="#addChapterModal">
                  {this.props.name !== '' && <i className="far fa-plus-square fa-2x " />}
                </button>
              </div>
              <div className="chapters">
                {
                  this.props.menu && this.props.menu.menuChapters.map(chapter =>
                      <div key={chapter.id + chapter.name} className="chapter">
                        <div className="chapter-title">
                          {chapter.name}
                          <button type="button"
                                  className="button-without-styles"
                                  data-toggle="modal"
                                  data-target="#addSubChapterModal"
                                  onClick={() => this.setState({ currentChapter: chapter.name })}>
                            {this.props.name !== '' && <i className="far fa-plus-square fa-2x addSubChapter" /> }
                          </button>
                        </div>
                        <div className="subChapters">
                          {
                            chapter.menuSubchapters.map(subChapter =>
                                <div key={subChapter.id + subChapter.name} className="subChapter">
                                  <div className="subChapter-title">
                                    {subChapter.name}
                                    <button type="button"
                                            className="button-without-styles"
                                            data-toggle="modal"
                                            data-target="#addDishModal"
                                            onClick={() => this.setState({
                                              currentChapter: chapter.name,
                                              currentSubChapter: subChapter.name
                                            })}>
                                      {this.props.name !== '' &&  <i className="far fa-plus-square fa-2x addDish" />}
                                    </button>
                                  </div>
                                  <div className="dishes">
                                    {
                                      subChapter.menuDishes.map(dish =>
                                          <div key={dish.id + dish.name} className="dish">
                                            <img className="dish-image" alt="" src={dish.mainImage ? `http://localhost:9000/images/${dish.mainImage}` : dishPhoto} />
                                            <div className="dish-title"> {dish.name} </div>
                                            <div>Rating: {dish.rating} </div>
                                            <div>Price : {dish.price}</div>
                                          </div>
                                      )
                                    }

                                  </div>
                                </div>
                            )
                          }
                        </div>
                      </div>
                  )
                }
              </div>
            </div>
          </div>

          <div className="modals">
            <ChapterModal id={this.props.current.id} update={this.updateCateringMenu} />

            <SubChapterModal id={this.props.current.id}
                             update={this.updateCateringMenu}
                             currentChapter={currentChapter} />

            <DishModal id={this.props.current.id}
                       update={this.updateCateringMenu}
                       currentChapter={currentChapter}
                       currentSubChapter={currentSubChapter} />
          </div>
        </div>
    );
  }
}

const mapStateToProps = store => ({
  menu: store.caterings.current.menu,
  current: store.caterings.current,
  name: store.user.username
});

const mapDispatchToProps = dispatch => ({
  getCateringMenu: id => dispatch(getCurrentCateringMenu(id))
});

export default connect(
    mapStateToProps,
    mapDispatchToProps
)(CateringMenuPage);
