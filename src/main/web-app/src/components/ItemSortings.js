import React, { Component } from 'react';
import { connect } from 'react-redux';

class ItemSorting extends Component {
  constructor(props) {
    super(props);
    this.state = {
      highToLowPrice: null,
      ascendingTitle: null,
      goodToBadRating: null
    };
  }

  render() {
    const {highToLowPrice, ascendingTitle, goodToBadRating,} = this.state;
    const { menuData } = this.props;

    return (
        <div className="sort">
            {menuData.CATALOG_PAGE.SORT_TYPES.SORT_BY}

            <div className="category">
              {menuData.CATALOG_PAGE.SORT_TYPES.PRICE}
              <div className="option">
                <input
                    type="checkbox"
                    checked={highToLowPrice === null ? false : highToLowPrice}
                    onChange={() => this.setState({
                      highToLowPrice: highToLowPrice === null ? true : (highToLowPrice ? null : !highToLowPrice)
                    })} />
                <label>
                  {menuData.CATALOG_PAGE.SORT_TYPES.HIGH_TO_LOW}
                </label>
              </div>
              <div className="option">
                <input type="checkbox"
                       checked={highToLowPrice === null ? false : !highToLowPrice}
                       onChange={() => this.setState({
                         highToLowPrice: highToLowPrice === null ? false : (!highToLowPrice ? null : !highToLowPrice)
                       })} />
                <label>
                  {menuData.CATALOG_PAGE.SORT_TYPES.LOW_TO_HIGH}
                </label>
              </div>
            </div>

            <div className="category">
              {menuData.CATALOG_PAGE.SORT_TYPES.TITLE}

              <div className="option">
                <input type="checkbox"
                       checked={ascendingTitle === null ? false : ascendingTitle}
                       onChange={() => this.setState({
                         ascendingTitle: ascendingTitle === null ? true : (ascendingTitle ? null : !ascendingTitle)
                       })} />
                <label>
                  {menuData.CATALOG_PAGE.SORT_TYPES.ASCENDING}
                </label>
              </div>
              <div className="option">
                <input type="checkbox"
                       checked={ascendingTitle === null ? false : !ascendingTitle}
                       onChange={() => this.setState({
                         ascendingTitle: ascendingTitle === null ? false : (!ascendingTitle ? null : !ascendingTitle)
                       })} />
                <label>
                  {menuData.CATALOG_PAGE.SORT_TYPES.DESCENDING}
                </label>
              </div>
            </div>

            <div className="category">
              {menuData.CATALOG_PAGE.SORT_TYPES.RATING}

              <div className="option">
                <input type="checkbox"
                       checked={goodToBadRating === null ? false : goodToBadRating}
                       onChange={() => this.setState({
                         goodToBadRating: goodToBadRating === null ? true : (goodToBadRating ? null : !goodToBadRating)
                       })} />
                <label>
                  {menuData.CATALOG_PAGE.SORT_TYPES.FROM_GOOD_TO_BAD}
                </label>
              </div>
              <div className="option">
                <input type="checkbox"
                       checked={goodToBadRating === null ? false : !goodToBadRating}
                       onChange={() => this.setState({
                         goodToBadRating: goodToBadRating === null ? false : (!goodToBadRating ? null : !goodToBadRating)
                       })} />
                <label>
                  {menuData.CATALOG_PAGE.SORT_TYPES.FROM_BAD_TO_GOOD}
                </label>
              </div>
            </div>

        </div>
    );
  }
}

const mapStateToProps = store => ({
  menuData: store.languages.menuData
});

export default connect(
    mapStateToProps
)(ItemSorting);
