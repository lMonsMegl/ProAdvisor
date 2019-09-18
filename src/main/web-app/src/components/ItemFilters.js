import React, { Component } from 'react';
import { connect } from 'react-redux';
import { CountryDropdown, RegionDropdown } from 'react-country-region-selector';

class ItemFilters extends Component {
  constructor(props) {
    super(props);
    this.state = {
      country: '',
      region: '',
      recommendedByFriends: false
    };
  }

  render() {
    const {country, region, recommendedByFriends } = this.state;
    const { menuData } = this.props;

    return (
        <div className="filters">
            {menuData.CATALOG_PAGE.FILTERS.FILTERS_BY}
            <div className="category">
              {menuData.CATALOG_PAGE.FILTERS.PLACE}
              <div className="filter-option">
                <CountryDropdown
                    className="country-dropdown"
                    value={country}
                    onChange={(val) => this.setState({ country: val })} />
              </div>
              <div className="filter-option">
                <RegionDropdown
                    className="country-dropdown"
                    country={country}
                    value={region}
                    onChange={(val) => this.setState({ region: val })} />
              </div>
            </div>
            <div className="category">
              {menuData.CATALOG_PAGE.FILTERS.PRICE}
              <i className="fas fa-chevron-down" />
              <div>
                <input className="price-input" type="number" />
                {menuData.CATALOG_PAGE.FILTERS.TO}
                <input className="price-input" type="number" />
              </div>
            </div>
            <div className="category">
              <input
                  type="checkbox"
                  checked={recommendedByFriends}
                  onChange={() => this.setState(prevState => ({
                    recommendedByFriends: !prevState.recommendedByFriends
                  }))} />
              <label>
                {menuData.CATALOG_PAGE.FILTERS.RECOMMENDED}
              </label>
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
)(ItemFilters);
