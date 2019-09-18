import React, { Component } from 'react';
import PropTypes from 'prop-types';
import { addSubChapter } from '../../actions/request/caterings';

class SubChapterModal extends Component {
  static propTypes = {
    id: PropTypes.number.isRequired,
    currentChapter: PropTypes.string.isRequired,
    update: PropTypes.func.isRequired
  };

  constructor(props) {
    super(props);
    this.state = {
      newSubChapter: '',
      notCompletedField: ''
    };
  }

  onAddSubChapter = () => {
    this.state.newSubChapter === '' ? this.setState({ notCompletedField: 'This field is required' })
        : addSubChapter(this.props.id, this.props.currentChapter, { name: this.state.newSubChapter })
            .then(() => this.props.update());
  };

  render() {
    const { newSubChapter } = this.state;

    return (
        <div className="modal fade" id="addSubChapterModal" tabIndex="-1" role="dialog"
             aria-labelledby="addSubChapterModalLabel" aria-hidden="true">
          <div className="modal-dialog" role="document">
            <div className="modal-content">
              <div className="modal-header">
                <h5 className="modal-title" id="addSubChapterModalLabel">Add SubChapter</h5>
                <button type="button" className="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              <div className="modal-body">
                <input type="text"
                       placeholder="SubChapter Name..."
                       value={newSubChapter}
                       onChange={event => this.setState({ newSubChapter: event.target.value })} />
                <div className="error-message">{this.state.notCompletedField}</div>
              </div>

              <div className="modal-footer">
                <button type="button" className="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button"
                        className="btn btn-primary"
                        data-dismiss={this.state.newSubChapter !== '' && 'modal'}
                        onClick={this.onAddSubChapter}>
                  Add
                </button>
              </div>
            </div>
          </div>
        </div>
    );
  }
}

export default SubChapterModal;
